insert into price_entity(id, price, updated, fraction_of_profit, profit_per_unit, total_revenue) values (1, 368, parsedatetime('05-05-2018 19:23:52', 'dd-MM-yyyy hh:mm:ss'), 0.09250000000000018, 24.666666666666714, 40700.00000000001);

INSERT INTO `competion` (`id`, `competion`, `price`, `updated`) VALUES (1, 'Amazon', 12, parsedatetime('2018-05-05 10:55:21', 'dd-MM-yyyy hh:mm:ss'));
INSERT INTO `competion` (`id`, `competion`, `price`, `updated`) VALUES (2, 'Amazon', 12, parsedatetime('2018-05-01 06:00:00', 'dd-MM-yyyy hh:mm:ss'));

INSERT INTO `notes` (`id`, `content`, `created_at`, `title`, `updated_at`) VALUES (1, '1', parsedatetime('2018-05-04 00:00:00', 'dd-MM-yyyy hh:mm:ss'), '1', parsedatetime('2018-05-01 00:00:00', 'dd-MM-yyyy hh:mm:ss'));


insert into price_entity_competitor(id, name, price, updated, fraction_of_profit, profit_per_unit, total_revenue) values (1, 'Amazon', 364, parsedatetime('05-05-2018 19:23:52', 'dd-MM-yyyy hh:mm:ss'), 0.09250000000000018, 24.666666666666714, 40700.00000000001);
insert into price_entity_competitor(id, name, price, updated, fraction_of_profit, profit_per_unit, total_revenue) values (2, 'Alibaba', 360, parsedatetime('05-05-2018 19:23:52', 'dd-MM-yyyy hh:mm:ss'), 0.09250000000000018, 24.666666666666714, 40700.00000000001);
insert into price_entity_competitor(id, name, price, updated, fraction_of_profit, profit_per_unit, total_revenue) values (3, 'Adjusted', 362, parsedatetime('05-05-2018 19:23:52', 'dd-MM-yyyy hh:mm:ss'), 0.09250000000000018, 24.666666666666714, 40700.00000000001);