alter table Patient
  add constraint fk_user_id_patient FOREIGN KEY (user_id) REFERENCES User(user_id);
alter table Doctor
  add constraint fk_user_id_doctor FOREIGN KEY (user_id) REFERENCES User(user_id);
alter table MedicalRecords
  add constraint fk_patient_id_medrecs FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
  add constraint fk_doctor_id_medrecs FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id);
alter table Visit
  add constraint fk_docvisit_id_visit FOREIGN KEY (docvisit_id) REFERENCES DoctorVisit(docvisit_id),
  add constraint fk_patient_id_visit FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
  add constraint fk_bill_id_visit FOREIGN KEY (bill_id) REFERENCES BillPayments(bill_id);
alter table DoctorVisit
  add constraint fk_prescription_id_docvisit FOREIGN KEY (prescription_id) REFERENCES Prescription(prescription_id),
  add constraint fk_doctor_id_docvisit FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
  add constraint fk_visit_id_docvisit FOREIGN KEY (visit_id) REFERENCES Visit(visit_id);
alter table Test
  add constraint fk_availtest_id_test FOREIGN KEY (availabletest_id) REFERENCES AvailableTest(availabletest_id),
  add constraint fk_visit_id_test FOREIGN KEY (visit_id) REFERENCES Visit(visit_id);
alter table Prescription
  add constraint fk_docvisit_id_presc FOREIGN KEY (docvisit_id) REFERENCES DoctorVisit(docvisit_id);
alter table Medicine
  add constraint fk_availmed_id_medicine FOREIGN KEY (availablemed_id) REFERENCES AvailableMedicine(availablemed_id),
  add constraint fk_prescription_id_medicine FOREIGN KEY (prescription_id) REFERENCES Prescription(prescription_id);
alter table BillPayments
  add constraint fk_visit_id_billpay FOREIGN KEY (visit_id) REFERENCES Visit(visit_id);
