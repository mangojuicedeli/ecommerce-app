# ecommerce-app

MSA 아키텍처 및 Spring Cloud를 기반으로 만들어 보는 E-Commerce 애플리케이션 + CI/CD

---
## Cloud Native Architecture

- 확장 가능성이 높은
	* 시스템의 수평적 확장에 유연
	* 확장된 서버로 시스템의 부하 분산, 가용성 보장
	* 시스템 또는, 서비스 애플리케이션 단위의 패키지 (컨테이너 기반 패키지)
	
- 탄력적인
	* 서비스 생성-통합-배포, 비즈니스 환경 변화에 대응 시간 단축
	* 분할된 서비스 구조
	* 서비스의 추가와 삭제를 자동으로 감지
	* 변경된 서비스 요청에 따라 동적 처리
	
- 장애 격리
	* 특정 서비스에 오류가 발생해도 다른 서비스에 영향 주지 않음
	
---
## CI/CD

- CI/CD
	*  '개발 -> 테스트 -> 빌드 -> 릴리즈 -> 배포'을 자동화하여 짧고 빠르게 사이클을 반복할 수 있게 한다 

- 지속적인 통합(Continuous Integration)
	* 소스 관리(SCM), 테스트
	* Ex) Jenkins, Github Action, Travis CI
	
- 지속적인 배포(Continuous Delivery[Deployment])
	* Delivery: 개발 환경에서의 릴리즈까지의 자동하ㅗ
	* Deployment: Delivery + 실제 운영 환경 배포까지 자동화.
	* 카나리 배포와 블루그린 배포
