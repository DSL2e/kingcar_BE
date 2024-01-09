# 👑KingCar-내 차 어때 
자동차 시승 직거래 서비스 '내 차 어때'의 `백엔드` 개발을 위한 레포지토리입니다.
> 현대자동차그룹 소프티어 3기</br>
> 개발기간: 2024.01.05 - 2024.01.09

## 🚘프로젝트 소개
### <U>*"슈퍼카 오너에게는 자랑의 기회를, 예비 소비자에게는 시승의 기회를"*</U>

### 🤞해결하고 싶었던 문제
- 슈퍼카는 수많은 이들의 로망이다. 
- 그러나 비싼 가격 때문에 직접 타볼 수 있는 기회는 거의 없다.
- 대리점 시승을 하려고 해도 부가비용(시간, 노력 등)이 크다.
- 슈퍼카 커뮤니티의 진입장벽이 높다.

### 👍해결 방법
- 슈퍼카 오너와 예비 소비자를 연결해 시승 기회를 제공한다.
- 슈퍼카를 소유한 오너를 직접 만나 궁금증을 직접 해결할 수 있다.
- 오너 커뮤니티에서 정보 공유를 쉽게 할 수 있다.

## 😎KingCar팀 소개
| Back-End | Back-End | Android | PO/Design | PM |
|----------|----------|---------|-----------|----|
|   서지원   |  이대산   |  이상돈   |   구희윤   |  박정집  |

## ⚡️Stacks
<img src="https://img.shields.io/badge/java17-red?style=for-the-badge&logo=oracle&logoColor=white"> <img src="https://img.shields.io/badge/spring-green?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/gradle-blue?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/h2-white?style=for-the-badge&logo=java&logoColor=black"><img src="https://img.shields.io/badge/intelliJIDEA-black?style=for-the-badge&logo=intelliJIDEA&logoColor=white"></br>
<img src="https://img.shields.io/badge/amazon ec2-orange?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/amazon s3-deep green?style=for-the-badge&logo=amazons3&logoColor=white"></br>
<img src="https://img.shields.io/badge/github-black?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-red?style=for-the-badge&logo=git&logoColor=white">

## 💡API
[Postman API Document](https://documenter.getpostman.com/view/32166161/2s9YsJDYq5)

## 📁디렉터리 구조
~~~
kingcar_be
    ├── 📁 Config
    │   └── S3Config.java
    ├── 📁 Controller
    │   ├── ArticleController.java
    │   ├── ArticleDetailController.java
    │   ├── CarBrandController.java
    │   ├── CarModelController.java
    │   ├── ImageController.java
    │   ├── JoinController.java
    │   ├── MyPageController.java
    │   ├── NoticeController.java
    │   ├── RequestController.java
    │   └── loginController.java
    ├── 📁 DTO
    │   ├── ArticleDetail.java
    │   ├── ArticleElement.java
    │   ├── ArticleRequest.java
    │   ├── ArticleResponse.java
    │   ├── BrandRequest.java
    │   ├── BrandResponse.java
    │   ├── JoinRequest.java
    │   ├── MasterNotice.java
    │   ├── MemberIdResponse.java
    │   ├── ModelRequest.java
    │   ├── ModelResponse.java
    │   ├── MyPageResponse.java
    │   ├── NoticeResponse.java
    │   ├── RandomChoiceResponse.java
    │   ├── RequestRequest.java
    │   ├── Status.java
    │   └── WinnerNotice.java
    ├── 📁 Entity
    │   ├── Article.java
    │   ├── BrandImage.java
    │   ├── CarImage.java
    │   ├── Course.java
    │   ├── Member.java
    │   └── Request.java
    ├── 📁Exception
    │   ├── ErrorCode.java
    │   ├── ExceptionManager.java
    │   ├── NameDuplicationException.java
    │   └── RequestException.java
    ├── KingcarBeApplication.java
    ├── 📁 Repository
    │   ├── ArticleDetailRepository.java
    │   ├── ArticleRepository.java
    │   ├── BrandImageRepository.java
    │   ├── CourseRepository.java
    │   ├── MemberRepository.java
    │   ├── ModelImageRepository.java
    │   ├── MyPageRepository.java
    │   └── RequestRepository.java
    └── 📁 Service
        ├── ArticleDetailService.java
        ├── ArticleService.java
        ├── AwsService.java
        ├── CarBrandService.java
        ├── CarModelService.java
        ├── ImageService.java
        ├── JoinService.java
        ├── LoginService.java
        ├── MyPageService.java
        ├── NoticeService.java
        ├── RequestService.java
        └── S3Service.java
