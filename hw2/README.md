# 오늘의 담백질은... 🧐

Protein Foods List CRUD API

## 설명

뭐할지.. 고민하다가 식단 할때 있으면 편할 것 같은 담백질 음식 리스트를 구현하게 되었습니다!!

---

## ⭐ Features (Postman)

스크롤 귀찮은 당신을 위해..

1. [음식 추가 (POST) - **CREATE**](#1-post-음식-주가)
2. [저장된 음식 보기 (GET)- **READ**](#2-get-저장되어있는-음식을-한눈에-보기)
3. [음식 수정 (PUT) - **UPDATE**](#3-put-id-별-내용-수정)
4. [음식 삭제 (DELETE) - **DELETE**](#4-delete-id-별-음식-삭제하기)

### 1. (POST) 음식 주가

**URL**: `http://localhost:8080/protein-foods`

- Method: `POST`
- 예시 (JSON):

```json
{
  "name": "계란",
  "proteinGrams": 6,
  "calories": 78
}
```

- 실행결과:
  ![alt text](image.png)

---

---

### 2. (GET) 저장되어있는 음식을 한눈에 보기:

- Method: `GET`
- 실행결과:
  ![alt text](image-1.png)

### 3. (PUT) ID 별 내용 수정

**URL**: `http://localhost:8080/protein-foods/{id}`

- Method: `PUT`
- 예시 (JSON):

```json
{
  "name": "반숙계란",
  "proteinGrams": 6,
  "calories": 80
}
```

- 실행결과:
  ![alt text](image-2.png)

- GET After PUT:
  ![alt text](image-3.png)

---

### 4. (DELETE) ID 별 음식 삭제하기

**URL**: `http://localhost:8080/protein-foods/{id}`

- Method: `DELETE`
- 실행결과:
  ![alt text](image-4.png)

---
