# 🚀 Tên Dự Án: API Quản Lý Người Dùng và Blog (Project Name)

Dự án này là một API (hoặc ứng dụng) tập trung vào việc quản lý **Người dùng (Users)** và **Bài đăng (Blogs)**, bao gồm các chức năng cơ bản (CRUD) và các chức năng dành cho **Quản trị viên (Admin)**.

---

## 📂 Tổng Quan Cấu Trúc Dự Án



| Tệp tin | Loại tệp | Mô tả  |
| :--- | :--- | :--- |
| <img src="src/main/resources/images/post.png" alt="POST API" width="300"/> | Ảnh (API) | Mô tả một yêu cầu **POST** (ví dụ: tạo người dùng hoặc tạo bài blog). |
| **`application.properties`** | Cấu hình | Tệp cấu hình chính của ứng dụng (ví dụ: Spring Boot), chứa các thiết lập cơ sở dữ liệu, cổng, v.v. |
| <img src="src/main/resources/images/databaseusers.png" alt="Database Users" width="300"/> | Ảnh (DB) | Minh họa cấu trúc hoặc dữ liệu mẫu của bảng/collection **Users**. |
| <img src="src/main/resources/images/databaseblogs.png" alt="Database Blogs" width="300"/> | Ảnh (DB) | Minh họa cấu trúc hoặc dữ liệu mẫu của bảng/collection **Blogs**. |
| <img src="src/main/resources/images/put.png" alt="PUT API" width="300"/> | Ảnh (API) | Mô tả một yêu cầu **PUT** (Cập nhật tài nguyên). |
| <img src="src/main/resources/images/deleteblog.png" alt="Delete Blog" width="300"/> | Ảnh (API) | Minh họa chức năng xóa một bài đăng. |
| <img src="src/main/resources/images/deleteuser.png" alt="Delete User" width="300"/> | Ảnh (API) | Minh họa chức năng xóa một người dùng. |
| <img src="src/main/resources/images/userget.png" alt="User GET" width="300"/> | Ảnh (API) | Minh họa yêu cầu **GET** thông thường (ví dụ: xem hồ sơ cá nhân). |
| <img src="src/main/resources/images/admincreateuser.png" alt="Admin Create User" width="300"/> | Ảnh (Admin) | Minh họa chức năng **Admin** tạo tài khoản người dùng mới. |
| <img src="src/main/resources/images/adminchangeuser.png" alt="Admin Change User" width="300"/> | Ảnh (Admin) | Minh họa chức năng **Admin** thay đổi thông tin người dùng. |
| <img src="src/main/resources/images/adminget.png" alt="Admin GET" width="300"/> | Ảnh (Admin) | Minh họa yêu cầu **GET** dành cho Admin (ví dụ: xem danh sách tất cả người dùng). |
| <img src="src/main/resources/images/trytochange.png" alt="Try to Change" width="300"/> | Ảnh (API) | user không thể thay đổi blog của người khác. |

---

## 🔗 Các Endpoint API Quan Trọng

*(Dựa trên các tệp ảnh, đây là các chức năng chính mà API cung cấp. Bạn cần điều chỉnh đường dẫn cho đúng với dự án thực tế.)*

| Chức năng | Phương thức | Endpoint (Ví dụ) | Quyền truy cập |
| :--- | :--- | :--- | :--- |
| Tạo Tài nguyên | `POST` | `/api/blogs` hoặc `/api/users` | USER/PUBLIC |
| Cập nhật Tài nguyên | `PUT` | `/api/blogs/{id}` | USER/ADMIN |
| **Xóa Blog** | `DELETE` | `/api/blogs/{id}` | USER/ADMIN |
| **Admin** Lấy dữ liệu | `GET` | `/api/admin/users` | ADMIN |
| **Admin** Thay đổi User | `PUT` | `/api/admin/users/{id}` | ADMIN |
| **Admin** Xóa User | `DELETE` | `/api/admin/users/{id}` | ADMIN |

---

