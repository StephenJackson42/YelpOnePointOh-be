create Table reviews(
	review_id	bigserial primary key,
	body	varchar,
	score	int not null,
	author	varchar,
	business_name	varchar
	
)