create table reviews(
	review_id	bigserial primary key,
	body	varchar,
	score	varchar,
	author	varchar,
	business_name	varchar	
)