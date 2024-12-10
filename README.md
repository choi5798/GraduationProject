# 졸업프로젝트
이 레포는 JVM 기반의 Spring Boot 애플리케이션 레포입니다<br>
GraalVM 기반의 레포: https://github.com/choi5798/GraduationProjectHelper

## 실행하는 법
참고: https://knative.dev/docs/install/yaml-install/serving/install-serving-with-yaml/

### 0. 준비 사항
1. docker 설치
2. minikube 설치

### 1. minikube 실행
터미널을 열고 minikube 실행하기
```shell
minikube start
```

### 2. knative 설치 (v1.16.0 기준)
Knative Serving component 설치하기

필수 커스텀 리소스 설치
```shell
kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.16.0/serving-crds.yaml
```
Knative Serving 코어 컴포넌트 설치
```shell
kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.16.0/serving-core.yaml
```

### 3. 네트워킹 레이어 설치 (Kourier 기준)
로컬에서 Knative 클러스터에 접근 가능하게 함<br>
Knative Kourier 컨트롤러 설치
```shell
kubectl apply -f https://github.com/knative/net-kourier/releases/download/knative-v1.16.0/kourier.yaml
```

실제 접속하려면 새로운 터미널을 띄워 다음 명령어 입력해주기 (암호 요구 시 입력 해주기)
```shell
minikube tunnel
```

### 3-1. 설치 검증하기
다음 명령어로 설치가 잘 되었는지 검증 가능
```shell
kubectl get pods -n knative-serving
```
출력 예제:
```text
NAME                                      READY   STATUS    RESTARTS   AGE
3scale-kourier-control-54cc54cc58-mmdgq   1/1     Running   0          81s
activator-67656dcbbb-8mftq                1/1     Running   0          97s
autoscaler-df6856b64-5h4lc                1/1     Running   0          97s
controller-788796f49d-4x6pm               1/1     Running   0          97s
domain-mapping-65f58c79dc-9cw6d           1/1     Running   0          97s
domainmapping-webhook-cc646465c-jnwbz     1/1     Running   0          97s
webhook-859796bc7-8n5g2                   1/1     Running   0          96s
```

### 4. 서비스 확인하기
다음 명령어로 현재 실행중인 서비스들의 상태 및 접속 주소를 알 수 있다
```shell
kubectl get ksvc -n knative-serving
```
해당 주소로 접속한 뒤 `Hello ~~` 문구가 뜬다면 정상적으로 실행됐다고 볼 수 있다 
