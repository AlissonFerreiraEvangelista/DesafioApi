CREATE TABLE visit(
    id integer PRIMARY KEY,
    dat_of_week integer NOT NULL,
    data DATE NOT NULL,
    day_of_month integer NOT NULL,
    month integer NOT NULL,
    year integer NOT NULL,
    visits_id bigint,
    workspace_id bigint,
   
    CONSTRAINT fk_visit_workspace FOREIGN KEY (workspace_id) REFERENCES workspace(id),
    CONSTRAINT fk_visit_visits FOREIGN KEY (visits_id) REFERENCES visits(id)       
)