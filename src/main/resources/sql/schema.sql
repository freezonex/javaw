-- `database`.lotto definition

CREATE TABLE `lotto` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `period` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                         `number` json DEFAULT NULL,
                         `email` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                         `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `send_flag` int unsigned DEFAULT '0',
                         `del_flag` int unsigned DEFAULT '0',
                         `result` varchar(100) DEFAULT NULL,
                         `name` varchar(100) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=724 DEFAULT CHARSET=utf8mb4 ;


-- `database`.packinfo definition

CREATE TABLE `packinfo` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `desciption` varchar(10000) NOT NULL,
                            `submission_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `del_flag` int unsigned DEFAULT '0',
                            `familyName` varchar(500) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=utf8mb4 ;


-- `database`.packkeyword definition

CREATE TABLE `packkeyword` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `keyword` varchar(500) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ;


-- `database`.userlist definition

CREATE TABLE `userlist` (
                            `id` int unsigned NOT NULL AUTO_INCREMENT,
                            `open_id` varchar(500) NOT NULL,
                            `del_flag` int unsigned DEFAULT '0',
                            `familyName` varchar(500) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `open_id_UNIQUE` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_material definition

CREATE TABLE `wms_material` (
                                `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                `product_code` varchar(100) NOT NULL,
                                `name` varchar(100) NOT NULL,
                                `product_type` varchar(100) DEFAULT NULL,
                                `unit` varchar(100) DEFAULT NULL,
                                `note` varchar(200) DEFAULT NULL,
                                `specification` varchar(100) DEFAULT NULL,
                                `max` bigint DEFAULT NULL,
                                `min` bigint DEFAULT NULL,
                                `status` varchar(100) DEFAULT NULL,
                                `expect_wh_id` bigint DEFAULT NULL,
                                `expact_stock_location_id` bigint DEFAULT NULL,
                                `del_flag` tinyint(1) DEFAULT NULL,
                                `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_material_transaction definition

CREATE TABLE `wms_material_transaction` (
                                            `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                            `material_code` varchar(100) CHARACTER SET utf8mb4  NOT NULL,
                                            `type` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                            `source` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                            `inbound_id` bigint unsigned DEFAULT NULL,
                                            `stocktaking_id` bigint unsigned DEFAULT NULL,
                                            `outbound_id` bigint DEFAULT NULL,
                                            `warehouse_id` bigint DEFAULT NULL,
                                            `stock_location_id` bigint DEFAULT NULL,
                                            `rf_id` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                            `operator` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                            `inbound_status` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                            `outbound_status` varchar(100) DEFAULT NULL,
                                            `note` varchar(200) DEFAULT NULL,
                                            `inbound_creator` varchar(100) DEFAULT NULL,
                                            `outbound_creator` varchar(100) DEFAULT NULL,
                                            `inbound_purchase_order_no` varchar(100) DEFAULT NULL,
                                            `outbound_purchase_order_no` varchar(100) DEFAULT NULL,
                                            `inbound_supplier` varchar(100) DEFAULT NULL,
                                            `outbound_supplier` varchar(100) DEFAULT NULL,
                                            `inbound_delivery_date` timestamp NULL DEFAULT NULL,
                                            `outbound_delivery_date` timestamp NULL DEFAULT NULL,
                                            `del_flag` tinyint(1) DEFAULT NULL,
                                            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3648 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_rfid_material definition

CREATE TABLE `wms_rfid_material` (
                                     `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                     `rf_id` varchar(100) NOT NULL,
                                     `material_code` varchar(100) NOT NULL,
                                     `del_flag` tinyint(1) DEFAULT NULL,
                                     `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                     `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_storage_location definition

CREATE TABLE `wms_storage_location` (
                                        `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                        `warehouse_id` bigint unsigned NOT NULL,
                                        `name` varchar(100) NOT NULL,
                                        `occupied` tinyint(1) DEFAULT '0',
                                        `del_flag` tinyint(1) DEFAULT NULL,
                                        `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                        `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1481 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_threed_warehouse definition

CREATE TABLE `wms_threed_warehouse` (
                                        `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                        `location_id` bigint unsigned DEFAULT NULL,
                                        `location_name` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                        `material_name` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
                                        `del_flag` tinyint(1) DEFAULT NULL,
                                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1382 DEFAULT CHARSET=utf8mb4 ;


-- `database`.wms_warehouse definition

CREATE TABLE `wms_warehouse` (
                                 `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                 `warehouse_id` varchar(100) NOT NULL,
                                 `name` varchar(100) NOT NULL,
                                 `type` varchar(100) NOT NULL,
                                 `manager` varchar(100) DEFAULT NULL,
                                 `department` varchar(100) DEFAULT NULL,
                                 `email` varchar(200) DEFAULT NULL,
                                 `project_group` varchar(100) DEFAULT NULL,
                                 `note` varchar(200) DEFAULT NULL,
                                 `del_flag` tinyint(1) DEFAULT NULL,
                                 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`id`),
                                 UNIQUE KEY `name` (`name`),
                                 UNIQUE KEY `warehouse_id` (`warehouse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 ;