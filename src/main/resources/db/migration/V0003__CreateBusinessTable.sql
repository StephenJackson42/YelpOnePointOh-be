create table businesses(
	business_id bigserial primary key,
	business_name	varchar UNIQUE,
	address	varchar,
	website	varchar,
	hours	varchar,
	description varchar,	
)