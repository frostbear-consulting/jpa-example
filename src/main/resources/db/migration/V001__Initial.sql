CREATE TABLE Customer (
                          idCustomer serial not null primary key,
                          version int not null default 0,
                          firstName varchar(255),
                          lastName varchar(255)
);

CREATE TABLE lot_AccountType (
                                 code varchar(16) not null primary key,
                                 label_en varchar(255)
);

CREATE TABLE Account (
                         idAccount serial not null primary key,
                         balance decimal(15,5) not null,
                         owner int not null references Customer(idCustomer),
                         type varchar(16) not null references lot_AccountType(code)
);

INSERT INTO lot_AccountType values ('CH', 'Checking'), ('SV', 'Savings');