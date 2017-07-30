	create table reviews(
	review_id	bigserial primary key,
	body	varchar,
	score	varchar,
	author	varchar,
	link 	varchar,
	business_id bigint
	
)