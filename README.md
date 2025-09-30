# 🚀 Tên Dự Án: API Quản Lý Người Dùng và Blog (Project Name)

Dự án này là một API (hoặc ứng dụng) tập trung vào việc quản lý **Người dùng (Users)** và **Bài đăng (Blogs)**, bao gồm các chức năng cơ bản (CRUD) và các chức năng dành cho **Quản trị viên (Admin)**.

---

## 📂 Tổng Quan Cấu Trúc Dự Án

Dưới đây là danh sách các tệp tin quan trọng (chủ yếu là các ảnh chụp màn hình minh họa chức năng hoặc cấu hình) trong thư mục gốc của dự án.

![Ảnh chụp màn hình các tệp tin trong dự án](image_b143e7.png)

## 📂 Tổng Quan Cấu Trúc Dự Án

Dưới đây là danh sách các tệp tin quan trọng (chủ yếu là các ảnh chụp màn hình minh họa chức năng hoặc cấu hình) trong thư mục gốc của dự án.

![Ảnh chụp màn hình các tệp tin trong dự án](images/image_b143e7.png)

| Tệp tin | Loại tệp | Mô tả giả định |
| :--- | :--- | :--- |
| ![POST API](images/post.png) | Ảnh (API) | Mô tả một yêu cầu **POST** (ví dụ: tạo người dùng hoặc tạo bài blog). |
| **`application.properties`** | Cấu hình | Tệp cấu hình chính của ứng dụng (ví dụ: Spring Boot), chứa các thiết lập cơ sở dữ liệu, cổng, v.v. |
| ![Database Users](images/databaseusers.png) | Ảnh (DB) | Minh họa cấu trúc hoặc dữ liệu mẫu của bảng/collection **Users**. |
| ![Database Blogs](images/databaseblogs.png) | Ảnh (DB) | Minh họa cấu trúc hoặc dữ liệu mẫu của bảng/collection **Blogs**. |
| ![PUT API](images/put.png) | Ảnh (API) | Mô tả một yêu cầu **PUT** (Cập nhật tài nguyên). |
| ![Delete Blog](images/deleteblog.png) | Ảnh (API) | Minh họa chức năng xóa một bài đăng. |
| ![Delete User](images/deleteuser.png) | Ảnh (API) | Minh họa chức năng xóa một người dùng. |
| ![User GET](images/userget.png) | Ảnh (API) | Minh họa yêu cầu **GET** thông thường (ví dụ: xem hồ sơ cá nhân). |
| ![Admin Create User](images/admincreateuser.png) | Ảnh (Admin) | Minh họa chức năng **Admin** tạo tài khoản người dùng mới. |
| ![Admin Change User](images/adminchangeuser.png) | Ảnh (Admin) | Minh họa chức năng **Admin** thay đổi thông tin người dùng. |
| ![Admin GET](images/adminget.png) | Ảnh (Admin) | Minh họa yêu cầu **GET** dành cho Admin (ví dụ: xem danh sách tất cả người dùng). |
| ![Try to Change](images/trytochange.png) | Ảnh (API) | Minh họa một nỗ lực thay đổi hoặc một trường hợp kiểm tra quyền truy cập. |

---


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

## 📝 Đóng Góp (Contributing)

Chúng tôi hoan nghênh mọi đóng góp! Vui lòng tạo một **Issue** để báo cáo lỗi hoặc đề xuất tính năng, hoặc gửi **Pull Request** với những thay đổi của bạn.
