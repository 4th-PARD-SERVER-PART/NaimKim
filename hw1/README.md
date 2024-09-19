# HW1 - 나만의 Controller 만들어보기!

## Description
This project is a simple Spring Boot application that provides a "What to Eat(뭐먹지)" list. Users can add, update, delete, and get random meal recommendations via HTTP requests.

---

## Features
### 1. (GET) shows all meals in list http://localhost:8080/food/list
  - 기본 "list"를 추가해서 바로 돌려도 나옵니다!
  - error handler는 추가 X
  
![image](https://github.com/user-attachments/assets/0a2feb9f-0e4a-4bb4-a09f-d8652d04aa42)

### 2. (GET) random recommendation http://localhost:8080/food/recommend
  - error handler: if list is empty > ![image](https://github.com/user-attachments/assets/ae1b1c5a-6aba-4c83-9270-5634c08c50b0)

![image](https://github.com/user-attachments/assets/3a452646-f226-405e-aea1-26b6f2a20174)

### 3. (POST) add meal http://localhost:8080/food/add?meal=초밥

![image](https://github.com/user-attachments/assets/afd8546e-1f42-43fd-83ed-6226ce55b50d)

### 4. (PUT) update a meal by index http://localhost:8080/food/update/2?newMeal=굶어라그냥
  - error handler: if index is not found > ![image](https://github.com/user-attachments/assets/d2334ef7-fd56-4abe-956b-341129bb73c9)

![image](https://github.com/user-attachments/assets/fbd4094b-fdda-4eba-9ac6-5bdec924c9c3)

  - Check if it is updated with /food/list
<table>
  <tr>
    <th>Before</th>
    <th>After</th>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/63cec2a7-71f3-4e5d-96cd-95281e2d5c4c" alt="Before Image" width="400"/></td>
    <td><img src="https://github.com/user-attachments/assets/1e9b88a4-ab54-49be-9439-3a48a23bec3c" alt="After Image" width="400"/></td>
  </tr>
</table>

### 5. (DELETE) a meal by index http://localhost:8080/food/delete/2
  - error handler: if index is not found > ![image](https://github.com/user-attachments/assets/e8a1d9cb-a5d7-4528-9e5c-3ff922833092)

![image](https://github.com/user-attachments/assets/7e46ab61-2a9f-4c2b-a3a4-6485810bf412)

  - Check if it is deleted with /food/list
<table>
  <tr>
    <th>Before</th>
    <th>After</th>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/d312d4f4-1afb-42a0-9346-eef81fd5f69c" alt="Before Image" width="400"/></td>
    <td><img src="https://github.com/user-attachments/assets/ce10a118-e74d-4525-ba14-e7e107212c2e" alt="After Image" width="400"/></td>
  </tr>
</table>



