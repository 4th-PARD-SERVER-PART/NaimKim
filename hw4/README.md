# 💻 Basic Blog Platform API
This app is a simple CRUD (Create, Read, Update, Delete) platform that allows users to manage blog posts. 

## Features:

1. **[User Management](#1-user-feature-testing)**
  - **Create User**
  - **Retrieve User Details**
  - **Update User Information**
  - **Delete User**

2. **[Post Management](#2-post-feature-testing)**
  - **Create Post**
  - **Retrieve All Posts**
  - **Retrieve Post by ID**
  - **Update Post**
  - **Delete Post**

3. **[Like Toggle Feature](#3-like-feature-testing)**
  - **Toggle Like** (Users can like or unlike a post)
  - **Retrieve Like Count** (See the total number of likes for each post)

### Test appliation using Swagger
'http://localhost:8080/swagger-ui/index.html#/'

---

## 1. **User Feature Testing**

<table>
<tr>
<td>
  
#### a. **Create User**
- **Endpoint**: `POST /user`
- **Try it out json**:
 
     ```json 
     {
       "name": "Naim Kim"
     }
     ```
  - **Results 👉👉👉**

</td>
<td>

<img src="img_1.png" alt="Image" width="100%"/>

</td>
</tr>

<tr>
<td>

#### b. **Retrieve User Details by ID**

- **Endpoint**: `GET /user/{userId}`
- **Try it out**.
  - Execute with a valid `userId`.
- **Results 👉👉👉**

</td>
<td>

<img src="img_2.png" alt="Image"/>

</td>
</tr>

<tr>
<td>

#### c. **Update User Information**

- **Endpoint**: `PATCH /user/{userId}`
- **Try it out json**.
     ```json
     {
       "name": "Naanim Kim"
     }
     ```
- **Results 👉👉👉**

</td>
<td>

<img src="img_3.png" alt="Image"/>

</td>
</tr>
</table>

---

## 2. **Post Feature Testing**

<table>
<tr>
<td>

#### a. **Create a Post**

- **Endpoint**: `POST /post/{userId}`
- **Try it out json**.
     ```json
     {
       "title": "오늘의 일기",
       "content": "피곤하다."
     }
     ```
- **Results 👉👉👉**

</td>
<td>

<img src="img_5.png" alt="Image"/>

</td>
</tr>

<tr>
<td>

#### b. **Retrieve All Posts**

- **Endpoint**: `GET /post`
- **Results 👉👉👉**

</td>
<td>

<img src="img_7.png" alt="Image"/>

</td>
</tr>

<tr>
<td>

#### c. **Retrieve Post by ID**

- **Endpoint**: `GET /post/{postId}`
- **Execute**.
- **Results 👉👉👉**

</td>
<td>

<img src="img_6.png" alt="Image"/>

</td>
</tr>

<tr>
<td>

#### d. **Update a Post**

- **Endpoint**: `PATCH /post/{postId}/{userId}`
- **Try it out json**.
     ```json
     {
       "title": "어제 예언의 확신",
       "content": "피곤하다."
     }
     ```
- **Results 👉👉👉**

</td>
<td>

<img src="img_8.png" alt="Image"/>

</td>
</tr>

<tr>
<td>

#### e. **Delete a Post**

- **Endpoint**: `DELETE /post/{postId}/{userId}`
- Select wnated post and Execute.
- **Results 👉👉👉**

</td>
<td>

<img src="img_9.png" alt="Image"/>

</td>
</tr>

</table>

---

## 3. **Like Feature Testing**

<table>
<tr>
<td>

#### a. **Toggle Like on a Post**

- **Endpoint**: `POST /like/{postId}/{userId}`
- Enter postId and userId to toggle like
- **Results 👉👉👉**

</td>
<td>

<img src="img_10.png" alt="Toggle Like Image"/>

다시 "누른다면"
<img src="img_11.png" alt="Toggle Unlike Image"/>
</td>
</tr>
</table>

---
