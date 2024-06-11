SBNZ projekat od primanju davalaca krvi

Back se instalira se isto kao kolokvijum iz sbnz (maven clean install model, kjar pa service i pokrenete service)
i ako maven zeza: mvn -N io.takari:maven:wrapper
Front je obican angular projekat potrebne stvari se instaliraju sa npm install, pokrece se sa ng serve (ili npx ng serve, ako samo ng nece iz nekog razloga)

Otvorite http://localhost:4200 i ceka vas upitnik za davaoca krvi (deo pravog, nisam ceo pravio, evo celog ako nekog interesuje https://reg.pravno-informacioni-sistem.rs/api/Attachment/prilozi/427747/prilog1.html)
Da biste prosli dalje, odgovorite na sve sa "Ne", ako na neki odgovorite sa "Da" iskljuceni ste iz procesa selekcije za odgovarajuce vreme. 
Dalje se generise random uzorak krvi na beku i vrse se provere, ako je sve validno mozete dati krv. Belezi se jedinica date krvi i vracate se na upitnik.
Davaoc krvi je zatim iskljucen iz procesa selekcije na 16 nedelja.

http://localhost:4200/stats je pregled zaliha cele krvi, nema nista interaktivno
