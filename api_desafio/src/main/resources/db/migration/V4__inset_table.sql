INSERT INTO workspace(id, description, kind, name) VALUES (1, 'Descrição', 'APP', 'nome do workspace');
INSERT INTO workspace(id, description, kind, name) VALUES (2, 'Kindro hero', 'APP', 'Kindro');
INSERT INTO workspace(id, description, kind, name) VALUES (3, 'My video website.', 'SITE', 'Tube Site');
INSERT INTO workspace(id, description, kind, name) VALUES (4, 'My video app', 'SITE', 'Video App');

INSERT INTO visits(id, app, site) VALUES (1, 11, 2);
INSERT INTO visits(id, app, site) VALUES (2, 34, 54);
INSERT INTO visits(id, app, site) VALUES (3, 31, 222);
INSERT INTO visits(id, app, site) VALUES (4, 31, 222);


INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (1, 2, '2022-07-27', 2, 2, 2022, 1, 1);
	
INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (2, 7, '2022-12-07', 6, 12, 2022, 2, 2);

INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (3, 7, '2019-12-04', 6, 12, 2019, 2, 2);
	
INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (4, 2, '2021-01-17', 17, 1, 2021, 3, 3);
	
INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (5, 2, '2022-06-20', 2, 6, 2022, 3, 3);
	
INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (6, 2, '2022-07-24', 2, 7, 2022, 4, 4);
	
INSERT INTO visit(
	id, dat_of_week, data, day_of_month, month, year, visits_id, workspace_id)
	VALUES (7, 2, '2018-07-24', 2, 7, 2018, 4, 4);
	
