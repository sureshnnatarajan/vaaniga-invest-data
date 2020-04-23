CREATE TABLE `vaaniga_invest`.`listed_company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serial_number` INT NOT NULL,
  `company_name` VARCHAR(1000) NOT NULL,
  `isin` VARCHAR(20) NULL,
  `bse_symbol` VARCHAR(100) NULL,
  `nse_symbol` VARCHAR(100) NULL,
  `mse_symbol` VARCHAR(100) NULL,
  `market_cap_categorization` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `serial_number_UNIQUE` (`serial_number` ASC));