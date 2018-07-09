BEGIN TRANSACTION;
CREATE TABLE "users" (
	`_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`email`	TEXT UNIQUE,
	`password`	TEXT,
	`nombre`	TEXT,
	`apellido`	TEXT,
	`ocupacion`	TEXT
);
INSERT INTO `users` VALUES (1,'admin','admin','admin','admin','administrador');
CREATE TABLE `tipo_user` (
	`id_tipo`	INTEGER NOT NULL,
	`detalle`	TEXT NOT NULL,
	PRIMARY KEY(`id_tipo`)
);
CREATE TABLE `beneficio` (
	`id_ben`	INTEGER NOT NULL,
	`id_tipo`	INTEGER NOT NULL UNIQUE,
	`estab`	TEXT NOT NULL,
	`descripcion`	TEXT NOT NULL,
	PRIMARY KEY(`id_ben`)
);
CREATE TABLE android_metadata (locale TEXT);
INSERT INTO `android_metadata` VALUES ('en_US');
COMMIT;
