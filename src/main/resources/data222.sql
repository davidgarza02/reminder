--INSERT INTO category (name, res_Name) VALUES ('Utilities', 'ic_utilities');
--INSERT INTO category (name, res_Name) VALUES ('Credit Card', 'ic_credit_card');
--INSERT INTO category (name, res_Name) VALUES ('Rent', 'ic_rent');
--INSERT INTO category (name, res_Name) VALUES ('Loans', 'ic_loans');
--INSERT INTO category (name, res_Name) VALUES ('Streaming', 'ic_streaming');
--INSERT INTO category (name, res_Name) VALUES ('Pets', 'ic_pets');

--INSERT INTO member (full_Name,username, password) VALUES ('David Garza','user','pass');

--INSERT INTO member (full_Name,username, password) VALUES ('Michael Jackson','mich','1234');

INSERT INTO bills (name,notes,amount,repeat,category_id,user_id,due_date,is_deleted)
VALUES ('Amex platinum','Annual fee 10usd',532.12,'30','2','1',Date '2023-01-22',false);

--INSERT INTO bills (name,notes,amount,category_id,user_id,repeat,due_date,is_deleted)
--VALUES ('Car loan',null,328.10,'4','1',30,Date '2023-02-13',false);
--
--
--INSERT INTO bills (name,notes,amount,category_id,user_id,repeat,due_date,is_deleted)
--VALUES ('Mortgage payment',null,1300.44,'4','2',30,Date '2023-10-01',false);
--INSERT INTO bills (name,notes,amount,category_id,user_id,repeat,due_date,is_deleted)
--VALUES ('Morgan chase CredCard',null,328.10,'2','2',30,Date '2023-12-31',false);
--INSERT INTO bills (name,notes,amount,category_id,user_id,repeat,due_date,is_deleted)
--VALUES ('Netflix','Sharing account',29.99,'5','2',30,Date '2023-12-31',false);
