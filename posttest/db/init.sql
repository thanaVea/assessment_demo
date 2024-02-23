CREATE TABLE IF NOT EXISTS public.lottery
(
    id BIGINT NOT NULL,
    amount INTEGER,
    price NUMERIC(38,2),
    ticket_number CHARACTER VARYING(6) COLLATE pg_catalog."default",
    user_id INTEGER,
    CONSTRAINT lottery_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.user_ticket
(
    user_id INTEGER NOT NULL,
    total_price NUMERIC(10,2),
    CONSTRAINT user_ticket_pkey PRIMARY KEY (user_id)
);
