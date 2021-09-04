-- 1 Organization Газпром Добыча Уренгой
insert into organization (juridical_address,manager,name_organization,physical_address,id) values ('г.Москва,Ул. Вавилова, 19','Алексей Борисович Миллер','ООО «Газпром добыча Уренгой»','ул. Геологоразведчиков, 9, Новый Уренгой',1);
insert into department (contact_data,manager,name_department,organization_id,id) values ('gdu@mail.ru','Василий','УАВР',1,1);
insert into employee (name,patronymic,post,surname,department_id,id) values ('Антон','Сергеевич','Manager','Сергеев',1,1);
insert into employee (name,patronymic,post,surname,department_id,id) values ('Петя','Андреевич','Manager','Петров',1,2);
insert into task (data_execution,object_task,sign_control,sign_execution,text_task,author_task_id,executors_task_id,id) values ('2 недели','Супер задание!!!','Признак контрольности','Признак исполнения','Пойди туда, не знаю куда... Найди то, не знаю чё...',1,2,1);
-- 2 Organization СберБанк
insert into organization (juridical_address,manager,name_organization,physical_address,id) values ('г.Белебей,Ул. Южная, 21','Павлова Ольга Васильевна','ООО «СберБанк»','ул. Северная, 21, Москва',2);
insert into department (contact_data,manager,name_department,organization_id,id) values ('sber@mail.ru','Ольга','Быстро Деньги',2,2);
insert into employee (name,patronymic,post,surname,department_id,id) values ('Мария','Андреевна','Manager','Сабирова',2,3);
insert into employee (name,patronymic,post,surname,department_id,id) values ('Екатерина','Васильевна','Manager','Кокова',2,4);
insert into task (data_execution,object_task,sign_control,sign_execution,text_task,author_task_id,executors_task_id,id) values ('3 недели','Супер задание!!!','Признак контрольности','Признак исполнения','Сделай что-то полезное!!!',3,4,2);