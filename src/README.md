
# Общее описание

На языке Java реализовать обращение к адресу
https://eltex-co.ru/test/users.php
отфильтровать пользователей по `salary > 3500`
отсортировать пользователей в алфавитном порядке по имени
результат выдать в формате CSV 1ая строка - названия столбцов.
Код проекта предоставить на github
результат - файл csv в каталоге
`README` с инструкцией
(плюсом будет реализация с использованием `Groovy`)

## Инструкция

1) Запустить файл `Connection.java`
2) Дождаться окончания работы файла `Connection.java`
3) Посмотреть результат вывода в файле `Users.csv`

### Используемые расширения языка java

		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-csv</artifactId>
			<version>1.10.0</version>
		</dependency>

		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.11.0</version>
		</dependency>