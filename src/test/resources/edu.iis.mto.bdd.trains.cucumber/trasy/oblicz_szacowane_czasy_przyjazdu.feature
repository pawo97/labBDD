# language: pl
Funkcja: Informacja dla podróżnych o czasie przybycia do stacji docelowej
	W celu bardziej efektywnego planowania podróży
	Jako podróżny
	Chcę wiedzieć, o której godzinie dotrę do stacji docelowej

Scenariusz: Szacowanie czasu przyjazdu 
		Zakładając chcę się dostać z Parramatta do TownHall
		I następny pociąg odjeżdża o 8:02 na linii Western
		Gdy zapytam o godzinę przyjazdu
		Wtedy powinienem uzyskać następujący szacowany czas przyjazdu: 8:29

Szablon scenariusza: Szacowanie czasu przyjazdu 
		Zakładając chcę się dostać z <start> do <end>
		I następny pociąg odjeżdża o <time> na linii <line>
		Gdy zapytam o godzinę przyjazdu
		Wtedy powinienem uzyskać następujący szacowany czas przyjazdu: <arrivalTime>
		
Przykłady:
		| start    | end     | departureTime | line      | arrivalTime |
		| Epping   | Central | 8:13          | Epping    | 8:51        |		
		| Epping   | Central | 8:03          | Northern  | 8:48        |
