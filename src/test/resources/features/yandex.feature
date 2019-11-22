# language: ru

Функция: Яндек Маркет Телевизоры
  Сценарий: Проверка поиска на соответствие

    Тогда пользователь выбирает вкладку "Маркет" на панели навигации
    * пользователь выбирает отдел "Электроника" в Яндекс маркете
    * пользователь выбирает раздел "Телевизоры" в подМеню
    * пользователь проверяет, что он в правильном разделе "Телевизоры"
    * пользователь задаёт характеристики поиска
      |Диагональ         |50"-55"       |
      |Разрешение HD     |1080p Full HD |
      |Производитель     |LG       |

    * пользователь устанавливает минимальную сумму в "60000" в фильтре
    * пользователь проверяет, что по результату поиска получено "8" элементов
    * пользователь вводит "1" элемент в поле поиска
    * пользователь проверяет что товар соответствует найденому