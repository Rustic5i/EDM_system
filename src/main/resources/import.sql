-- 1 Organization ������� ������ �������
insert into organization (juridical_address,manager,name_organization,physical_address,id) values ('�.������,��. ��������, 19','������� ��������� ������','��� �������� ������ �������','��. ������������������, 9, ����� �������',1);
insert into department (contact_data,manager,name_department,organization_id,id) values ('gdu@mail.ru','�������','����',1,1);
insert into employee (name,patronymic,post,surname,department_id,id) values ('�����','���������','Manager','�������',1,1);
insert into employee (name,patronymic,post,surname,department_id,id) values ('����','���������','Manager','������',1,2);
insert into task (data_execution,object_task,sign_control,sign_execution,text_task,author_task_id,executors_task_id,id) values ('2 ������','����� �������!!!','������� �������������','������� ����������','����� ����, �� ���� ����... ����� ��, �� ���� ��...',1,2,1);
-- 2 Organization ��������
insert into organization (juridical_address,manager,name_organization,physical_address,id) values ('�.�������,��. �����, 21','������� ����� ����������','��� ���������','��. ��������, 21, ������',2);
insert into department (contact_data,manager,name_department,organization_id,id) values ('sber@mail.ru','�����','������ ������',2,2);
insert into employee (name,patronymic,post,surname,department_id,id) values ('�����','���������','Manager','��������',2,3);
insert into employee (name,patronymic,post,surname,department_id,id) values ('���������','����������','Manager','������',2,4);
insert into task (data_execution,object_task,sign_control,sign_execution,text_task,author_task_id,executors_task_id,id) values ('3 ������','����� �������!!!','������� �������������','������� ����������','������ ���-�� ��������!!!',3,4,2);