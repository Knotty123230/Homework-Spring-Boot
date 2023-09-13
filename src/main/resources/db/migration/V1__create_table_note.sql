create table Note
(
    id serial primary key ,
    title varchar(255),
    content varchar(2000)

);
CREATE TABLE IF NOT EXISTS authorities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL
    );
