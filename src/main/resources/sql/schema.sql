-- `database`.wms_material definition

CREATE TABLE IF NOT EXISTS `wms_material` (
                                `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                `product_code` varchar(100) NOT NULL,
                                `name` varchar(100) NOT NULL,
                                `product_type` varchar(100) DEFAULT NULL,
                                `unit` varchar(100) DEFAULT NULL,
                                `note` varchar(200) DEFAULT NULL,
                                `del_flag` tinyint(1) DEFAULT NULL,
                                `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `database`.wms_material_transaction definition

CREATE TABLE IF NOT EXISTS `wms_material_transaction` (
                                            `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                            `material_id` bigint NOT NULL,
                                            `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                            `source` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                            `inbound_id` bigint unsigned DEFAULT NULL,
                                            `stocktaking_id` bigint unsigned DEFAULT NULL,
                                            `outbound_id` bigint DEFAULT NULL,
                                            `warehouse_id` bigint DEFAULT NULL,
                                            `stock_location_id` bigint DEFAULT NULL,
                                            `rf_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                            `operator` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                            `status` varchar(100) DEFAULT NULL,
                                            `note` varchar(200) DEFAULT NULL,
                                            `del_flag` tinyint(1) DEFAULT NULL,
                                            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `database`.wms_storage_location definition

CREATE TABLE IF NOT EXISTS `wms_storage_location` (
                                        `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                        `warehouse_id` bigint unsigned NOT NULL,
                                        `name` varchar(100) NOT NULL,
                                        `occupied` tinyint(1) DEFAULT '0',
                                        `del_flag` tinyint(1) DEFAULT NULL,
                                        `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                        `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `database`.wms_warehouse definition

CREATE TABLE IF NOT EXISTS `wms_warehouse` (
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
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;