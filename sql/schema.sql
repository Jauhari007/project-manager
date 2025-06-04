-- schema.sql

CREATE DATABASE IF NOT EXISTS project_manager;
USE project_manager;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'mandor'
);

CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    customer VARCHAR(100) NOT NULL,
    status ENUM('instal', 'non-instal') NOT NULL,
    start_date DATE,
    end_date DATE
);
