# ecommerce-app

MSA 아키텍처 및 Spring cloud를 기반으로 만들어 보는 Ecommerce 애플리케이션

---
## Cloud Native Architecture

- 확장 가능한 아키텍처
	* 시스템의 수평적 확장에 유연
	* 확장된 서버로 시스템의 부하 분산, 가용성 보장
	* 시스템 또는, 서비스 애플리케이션 단위의 패키지 (컨테이너 기반 패키지)
	* 모니터링
	
- 탄력적 아키텍처
	* 서비스 생성-통합-배포, 비즈니스 환경 변화에 대응 시간. 단축
	* 분할된 서비스 구조
	* 서비스의 추가와 삭제 자동으로 감지
	* 변경된 서비스 요청에 따라 사용자 요청 처리(동적 처리)
	
- 장애 격리(Fault isolation)
	* 특정 서비스에 오류가 발생해도 다른 서비스에 영향 주지 않음
	
---
## Cloud Native Application - CI/CD
- 지속적인 통합(CI)
	* 통합 서버, 소스 관리(SCM), 빌드 도구, 테스트 도구
	* Ex) Jenkins, Team CI, Travis CI
- 지속적인 배포(CD)
	* Continuous Delivery, Continuous Deployment
	* Pipe line
	* 카나리 배포와 블루그린 배포