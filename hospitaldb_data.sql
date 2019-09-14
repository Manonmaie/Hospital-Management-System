insert into User( user_id, password)
  VALUES('P000001','XYZ123');
insert into User( user_id, password)
  VALUES('P000002','ABC456');
insert into User( user_id, password)
  VALUES('P000003','auefgwf');
insert into User( user_id, password)
  VALUES('P000004','shjfg89');
insert into User( user_id, password)
  VALUES('P000005','segf*34');
insert into User( user_id, password)
  VALUES('P000006','aesfg9');
insert into User( user_id, password)
  VALUES('P000007','saefgawe56');
insert into User(user_id,password)
  VALUES('D0001','1234');
insert into User(user_id,password)
  VALUES('D0002','gsuy');
insert into User(user_id,password)
  VALUES('D0003','mhvxh');
insert into User(user_id,password)
  VALUES('D0004','nbvhm');
insert into User(user_id,password)
  VALUES('D0005','7tyku');
insert into User(user_id,password)
  VALUES('F0001','1hgvh');
insert into User(user_id,password)
  VALUES('M0001','hmvmhv');

insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100001,'P000001','Ava',20,'F');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100002,'P000002','Olivia',10,'F');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100003,'P000003','Hazel',7,'F');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100004,'P000004','Riley',35,'F');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100005,'P000005','Parker',25,'F');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100006,'P000006','Arjun',27,'M');
insert into Patient(patient_id, user_id, name, age, sex)
  VALUES(100007,'P000007','Radhini',16,'F');

insert into Doctor(doctor_id, user_id, name, consultation_fee, specialization, experience)
  VALUES(800001,'D0001','Manonmaie',500,'Gynaecology',5);
insert into Doctor(doctor_id, user_id, name, consultation_fee, specialization, experience)
  VALUES(800002,'D0002','Akshara',300,'Physician',7);
insert into Doctor(doctor_id, user_id, name, consultation_fee, specialization, experience)
  VALUES(800003,'D0003','Vaishnavi',500,'Dermatologist',3);
insert into Doctor(doctor_id, user_id, name, consultation_fee, specialization, experience)
  VALUES(800004,'D0004','Kavya',400,'Endocrinologist',8);
insert into Doctor(doctor_id, user_id, name, consultation_fee, specialization, experience)
  VALUES(800005,'D0005','Soumya',300,'ENT',15);

insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500001,100001,800004,'stomach pain','1888-07-12 03:45:30','excercise and take dolo');
insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500002,100003,800005,'ear pain','1878-05-02 05:42:50','take ear drops');
insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500003,100001,800001,'period cramps','1886-01-01 02:05:00','take rest and take meftal space');
insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500004,100002,800002,'knee pain','2012-12-12 12:12:12','take rest and apply ointment');
insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500005,100005,800002,'lower back pain','1888-07-12 03:45:30','visit again with x-ray');
insert into MedicalRecords( record_id, patient_id, doctor_id, disease, record_date, treatment)
  VALUES(500006,100007,800003,'rashes','1999-09-13 05:05:33','apply cream');

INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (1,NULL,100001,NULL,'2018-03-01 03:15:45',500);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (2,NULL,100002,NULL,'2018-02-11 02:55:45',600);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (3,NULL,100003,NULL,'2018-03-01 06:15:55',700);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (4,NULL,100001,NULL,'2018-12-04 08:05:05',800);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (5,NULL,100007,NULL,'2018-03-11 06:08:19',900);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (6,NULL,100002,NULL,'2018-06-12 04:44:44',1000);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (7,NULL,100005,NULL,'2018-03-01 03:15:45',550);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (8,NULL,100001,NULL,'2018-03-01 03:15:45',550);
INSERT INTO Visit(visit_id,docvisit_id,patient_id,bill_id,timeslot,cost)
    VALUES (9,NULL,100003,NULL,'2018-12-11 11:11:11',650);

INSERT INTO DoctorVisit(docvisit_id,prescription_id,doctor_id,visit_id,reason)
  VALUES (1,NULL,800001,2,'stomach pain');
INSERT INTO DoctorVisit(docvisit_id,prescription_id,doctor_id,visit_id,reason)
  VALUES (2,NULL,800002,3,'period crams');
INSERT INTO DoctorVisit(docvisit_id,prescription_id,doctor_id,visit_id,reason)
  VALUES (3,NULL,800005,5,'pimples');
INSERT INTO DoctorVisit(docvisit_id,prescription_id,doctor_id,visit_id,reason)
  VALUES (4,NULL,800004,8,'ear pain');
INSERT INTO DoctorVisit(docvisit_id,prescription_id,doctor_id,visit_id,reason)
  VALUES (5,NULL,800002,7,'back pain');

insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(001,'HEMOGRAM','nonfasting',1000);
insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(002,'THYROID STIMULATING HORMONE','nonfasting',1500);
insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(003,'HbA1c','nonfasting',100);
insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(004,'FASTING BLOOD SUGAR','fasting',1250);
insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(005,'HEMOGLOBIN ELECTROPHORESIS','nonfasting',2000);
insert into AvailableTest(availabletest_id,name,requirements,price)
  VALUES(006,'HOMOCYSTEINE','fasting',250);

insert into Test(test_id,availabletest_id,visit_id,name)
  VALUES(1,001,3,'hemoglobin');
insert into Test(test_id,availabletest_id,visit_id,name)
  VALUES(2,001,1,'hemoglobin');
insert into Test(test_id,availabletest_id,visit_id,name)
  VALUES(3,004,4,'diabeties');
insert into Test(test_id,availabletest_id,visit_id,name)
  VALUES(4,002,6,'thyroid');
insert into Test(test_id,availabletest_id,visit_id,name)
  VALUES(5,005,4,'hemoglobin');

INSERT INTO Prescription(prescription_id,docvisit_id,prescriptiondate)
  VALUES (1,5,'1999-03-01 03:15:45');
INSERT INTO Prescription(prescription_id,docvisit_id,prescriptiondate)
  VALUES (2,3,'1997-03-01 06:15:55');
INSERT INTO Prescription(prescription_id,docvisit_id,prescriptiondate)
  VALUES (3,4,'2011-12-11 11:11:11');
INSERT INTO Prescription(prescription_id,docvisit_id,prescriptiondate)
  VALUES (4,1,'2012-03-11 06:08:19');

insert into AvailableMedicine(availablemed_id,name,availablequantity,price,expirydate)
  values (0001,"CITRAZINE",400,2,'2019-12-5');
insert into AvailableMedicine(availablemed_id,name,availablequantity,price,expirydate)
  values (0002,"ZENFLOX OZ",250,89,'2020-04-25');
insert into AvailableMedicine(availablemed_id,name,availablequantity,price,expirydate)
  values (0003,"CIFRAN 500",430,38,'2020-02-08');
insert into AvailableMedicine(availablemed_id,name,availablequantity,price,expirydate)
  values (0004,"AZEE 500",320,222,'2019-11-25');
insert into AvailableMedicine(availablemed_id,name,availablequantity,price,expirydate)
  values (0005,"LIVOGEN XT",210,119,'2020-05-11');

insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (1,0001,1,"CITRAZINE",40);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (2,0004,1,"AZEE 500",25);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (3,0002,2,"ZENFLOX OZ",10);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (4,0005,3,"LIVOGEN",10);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (5,0004,3,"AZEE 500",20);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (6,NULL,3,"DOLO",20);
insert into Medicine(medicine_id,availablemed_id,prescription_id,name,quantity)
  values (7,0003,4,"CIFRAN 500",30);

INSERT INTO BillPayments(bill_id,visit_id,transaction_mode,amount,bill_date)
  VALUES (1,3,'cash',1000,'1999-03-01 03:15:45');
INSERT INTO BillPayments(bill_id,visit_id,transaction_mode,amount,bill_date)
  VALUES (2,2,'card',1500,'1997-03-01 06:15:55');
INSERT INTO BillPayments(bill_id,visit_id,transaction_mode,amount,bill_date)
  VALUES (3,1,'cash',2000,'2011-12-11 11:11:11');
INSERT INTO BillPayments(bill_id,visit_id,transaction_mode,amount,bill_date)
  VALUES (4,4,'card',2500,'2012-03-11 06:08:19');
INSERT INTO BillPayments(bill_id,visit_id,transaction_mode,amount,bill_date)
  VALUES (5,8,'cash',2800,'2001-03-01 03:15:45');

update DoctorVisit set prescription_id = 1 where docvisit_id = 5;
update DoctorVisit set prescription_id = 2 where docvisit_id = 3;
update DoctorVisit set prescription_id = 3 where docvisit_id = 4;
update DoctorVisit set prescription_id = 4 where docvisit_id = 1;

update Visit set bill_id = 1 where visit_id = 3;
update Visit set bill_id = 2 where visit_id = 2;
update Visit set bill_id = 3 where visit_id = 1;
update Visit set bill_id = 4 where visit_id = 4;
update Visit set bill_id = 5 where visit_id = 8;

update Visit set docvisit_id = 1 where visit_id = 2;
update Visit set docvisit_id = 2 where visit_id = 3;
update Visit set docvisit_id = 3 where visit_id = 5;
update Visit set docvisit_id = 4 where visit_id = 8;
update Visit set docvisit_id = 5 where visit_id = 7;
