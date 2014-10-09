insert into `t_user` (`id`, `username`, `password`) values
(1, 'qtp', 'a'),
(2, 'a', 'a');

insert into `t_user_role` (`id`, `user_id`, `role`) values
(1, 1, 'ADMIN'),
(2, 1, 'USER');

insert into `t_fund` (`id`, `name`) values
(1, 'Offensive Overlay'),
(2, 'Gold');

insert into `j_user_fund` (`user_id`, `fund_id`) values
(1, 1),
(1, 2);