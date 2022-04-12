DROP TABLE message;
DROP TABLE contact;
DROP TABLE client_information;

CREATE TABLE client_information(
client_phonenumber int,
client_firstname VARCHAR(45),
client_lastname VARCHAR(45),
client_password VARCHAR(45)
);

CREATE TABLE contact(
client_phonenumber INT,
contact_phonenumber INT,
contact_name VARCHAR(45)
);

CREATE TABLE message(
message_id INT auto_increment,
date_sent DATE,
data_received DATE,
client_phonenumber INT,
contact_phonenumber INT,
messagebody VARCHAR(160),
primary key (message_id)
);

alter table client_information
add constraint clientinfo_clientno_PK primary key (client_phonenumber)
;

alter table contact
add constraint contact_contactno_PK primary key (contact_phonenumber)
;

ALTER TABLE contact 
ADD CONSTRAINT clientinfo_message_clientno_FK  FOREIGN KEY(client_phonenumber)
REFERENCES client_information(client_phonenumber);


ALTER TABLE message 
ADD CONSTRAINT contact_message_contactno_FK  FOREIGN KEY(contact_phonenumber)
REFERENCES contact(contact_phonenumber);