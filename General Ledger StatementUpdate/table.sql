--------------------------------------------------------
--  File created - Wednesday-November-29-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUST_SLDOMESTIC_DOBAL
--------------------------------------------------------

  CREATE TABLE "CUSTOM"."CUST_SLDOMESTIC_DOBAL" 
   (	"BALANCE" NUMBER(*,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 16384 NEXT 40960 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into CUSTOM.CUST_SLDOMESTIC_DOBAL
Insert into CUSTOM.CUST_SLDOMESTIC_DOBAL (BALANCE) values (-54786);
