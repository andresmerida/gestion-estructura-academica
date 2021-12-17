INSERT INTO role (id, name ) values (1, 'Admin'),(2, 'HR'),(3, 'Manager');
INSERT INTO "user" (id, login, password) values (1, 'amerida', 'password');
INSERT INTO user_role (user_id, role_id) values (1,1);