-- CREATE TABLE IF NOT EXISTS goods
-- (
--     goods_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
--     title text COLLATE pg_catalog."default" NOT NULL,
--     price text COLLATE pg_catalog."default" NOT NULL,
--     CONSTRAINT goods_pkey PRIMARY KEY (goods_id)
-- )

INSERT INTO list_of_goods (title, price) VALUES ( 'table', 15.5);