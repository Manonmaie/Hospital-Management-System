drop database hospitaldb;
create database hospitaldb;
use hospitaldb;

create table User(
  user_id varchar(20),
  password varchar(30),
  constraint pk_user PRIMARY KEY(user_id)
);
create table Patient(
    patient_id int AUTO_INCREMENT,
    user_id varchar(20) NOT NULL UNIQUE,
    name varchar(30),
    age int,
    sex char,
    constraint pk_patient PRIMARY KEY(patient_id)
);
create table Doctor(
  doctor_id int AUTO_INCREMENT,
  user_id varchar(20) NOT NULL UNIQUE,
  name varchar(30),
  consultation_fee bigint,
  specialization varchar(50),
  experience int,
  constraint pk_doctor PRIMARY KEY(doctor_id)
);
create table MedicalRecords(
  record_id int AUTO_INCREMENT,
  patient_id int not NULL,
  doctor_id int not NULL,
  disease varchar(30),
  record_date date,
  treatment varchar(50),
  constraint pk_record PRIMARY KEY(record_id)
);
create table Visit(
  visit_id int AUTO_INCREMENT,
  docvisit_id int NULL,
  patient_id int not NULL,
  bill_id int,
  timeslot datetime,
  cost float,
  constraint pk_visit PRIMARY KEY(visit_id)
);
create table DoctorVisit(
  docvisit_id int AUTO_INCREMENT,
  prescription_id int UNIQUE,
  doctor_id int not NULL,
  visit_id int not NULL UNIQUE,
  reason varchar(50),
  constraint pk_docvisit PRIMARY KEY(docvisit_id)
);
create table Test(
  test_id int AUTO_INCREMENT,
  availabletest_id int not NULL,
  visit_id int not NULL,
  name varchar(30),
  constraint pk_test PRIMARY KEY(test_id)
);
create table AvailableTest(
  availabletest_id int AUTO_INCREMENT,
  name varchar(30),
  requirements varchar(50),
  price float,
  constraint pk_availabletest PRIMARY KEY(availabletest_id)
);
create table Prescription(
  prescription_id int AUTO_INCREMENT,
  docvisit_id int not NULL,
  prescriptiondate date not NULL,
  constraint pk_prescription PRIMARY KEY(prescription_id)
);
create table Medicine(
  medicine_id int AUTO_INCREMENT,
  availablemed_id int,
  prescription_id int not NULL,
  name varchar(30),
  quantity int,
  constraint pk_medicine PRIMARY KEY(medicine_id)
);
create table AvailableMedicine(
  availablemed_id int AUTO_INCREMENT,
  name varchar(30),
  availablequantity int,
  price int,
  expirydate date,
  constraint pk_availablemedicine PRIMARY KEY(availablemed_id)
);
create table BillPayments(
  bill_id int AUTO_INCREMENT,
  visit_id int not NULL UNIQUE,
  transaction_mode varchar(10),
  amount float,
  bill_date datetime,
  constraint pk_billpayments PRIMARY KEY(bill_id)
);
