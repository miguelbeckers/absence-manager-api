package absencemanager;

import absencemanager.model.entity.Absence;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import absencemanager.model.enumerator.AbsenceType;
import absencemanager.model.enumerator.UserType;
import absencemanager.repository.AbsenceRepository;
import absencemanager.repository.CrewRepository;
import absencemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZonedDateTime;

@Component
public class AbsenceManagerInitializer {
    private final UserRepository userRepository;
    private final AbsenceRepository absenceRepository;
    private final CrewRepository crewRepository;

    @Autowired
    public AbsenceManagerInitializer(
            UserRepository userRepository,
            AbsenceRepository absenceRepository,
            CrewRepository crewRepository
    ) {
        this.absenceRepository = absenceRepository;
        this.crewRepository = crewRepository;
        this.userRepository = userRepository;

        this.initialize();
    }

    public void initialize(){
        Crew crew = new Crew();
        crew.setName("crew-test");
        crew.setId(352L);

        crewRepository.save(crew);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user6 = new User();
        User user7 = new User();
        User user8 = new User();
        User user9 = new User();
        User user10 = new User();

        user1.setId(644L);
        user1.setCrew(crew);
        user1.setName("Max Schwarz");
        user1.setImage("https://loremflickr.com/300/400/cat");
        user1.setType(UserType.ADMITTER);
        user1.setEmail("max@crew.com");

        user2.setId(649L);
        user2.setCrew(crew);
        user2.setName("Ines de Oliveira");
        user2.setImage("https://loremflickr.com/300/400/fish");
        user2.setType(UserType.MEMBER);
        user2.setEmail("ines@crew.com");

        user3.setId(2290L);
        user3.setCrew(crew);
        user3.setName("Monika Müller");
        user3.setImage("https://loremflickr.com/300/400/dog");
        user3.setType(UserType.MEMBER);
        user3.setEmail("monika@crew.com");

        user4.setId(2664L);
        user4.setCrew(crew);
        user4.setName("Mike Janssen");
        user4.setImage("https://loremflickr.com/300/400/bird");
        user4.setType(UserType.MEMBER);
        user4.setEmail("mike@crew.com");

        user5.setId(2796L);
        user5.setCrew(crew);
        user5.setName("Bernhard Scherer");
        user5.setImage("https://loremflickr.com/300/400/canguru");
        user5.setType(UserType.MEMBER);
        user5.setEmail("bernhard@crew.com");

        user6.setId(2735L);
        user6.setCrew(crew);
        user6.setName("Manuel de Souza");
        user6.setImage("https://loremflickr.com/300/400/horse");
        user6.setType(UserType.MEMBER);
        user6.setEmail("manuel@crew.com");

        user7.setId(5293L);
        user7.setCrew(crew);
        user7.setName("Daniel Correa");
        user7.setImage("https://loremflickr.com/300/400/fox");
        user7.setType(UserType.MEMBER);
        user7.setEmail("danielcorrea@crew.com");

        user8.setId(5293L);
        user8.setCrew(crew);
        user8.setName("Daniel Silva");
        user8.setImage("https://loremflickr.com/300/400/duck");
        user8.setType(UserType.MEMBER);
        user1.setEmail("danielsilva@crew.com");

        user9.setId(5192L);
        user9.setCrew(crew);
        user9.setName("Sandra da Silva Santos");
        user9.setImage("https://loremflickr.com/300/400/lion");
        user9.setType(UserType.MEMBER);
        user1.setEmail("sandre@crew.com");

        user10.setId(8007L);
        user10.setCrew(crew);
        user10.setName("Linda Hanz");
        user10.setImage("https://loremflickr.com/300/400/bear");
        user10.setType(UserType.MEMBER);
        user1.setEmail("linda@crew.com");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);

        Absence absence1 = new Absence();
        Absence absence2 = new Absence();
        Absence absence3 = new Absence();
        Absence absence4 = new Absence();
        Absence absence5 = new Absence();
        Absence absence6 = new Absence();
        Absence absence7 = new Absence();
        Absence absence8 = new Absence();
        Absence absence9 = new Absence();
        Absence absence10 = new Absence();
        Absence absence11 = new Absence();
        Absence absence12 = new Absence();
        Absence absence13 = new Absence();
        Absence absence14 = new Absence();
        Absence absence15 = new Absence();
        Absence absence16 = new Absence();
        Absence absence17 = new Absence();
        Absence absence18 = new Absence();
        Absence absence19 = new Absence();
        Absence absence20 = new Absence();
        Absence absence21 = new Absence();
        Absence absence22 = new Absence();
        Absence absence23 = new Absence();
        Absence absence24 = new Absence();
        Absence absence25 = new Absence();
        Absence absence26 = new Absence();
        Absence absence27 = new Absence();
        Absence absence28 = new Absence();
        Absence absence29 = new Absence();
        Absence absence30 = new Absence();
        Absence absence31 = new Absence();
        Absence absence32 = new Absence();
        Absence absence33 = new Absence();
        Absence absence34 = new Absence();
        Absence absence35 = new Absence();
        Absence absence36 = new Absence();
        Absence absence37 = new Absence();
        Absence absence38 = new Absence();
        Absence absence39 = new Absence();
        Absence absence40 = new Absence();
        Absence absence41 = new Absence();
        Absence absence42 = new Absence();

        absence1.setId(2351L);
        absence1.setCrew(crew);
        absence1.setUser(user4);
        absence1.setType(AbsenceType.sickness);
        absence1.setCreatedAt(ZonedDateTime.parse("2020-12-12T14:17:01.000+01:00"));
        absence1.setStartDate(Date.valueOf("2021-01-13"));
        absence1.setEndDate(Date.valueOf("2021-01-13"));
        absence1.setMemberNote("");
        absence1.setAdmitter(user1);
        absence1.setConfirmedAt(ZonedDateTime.parse("2020-12-12T18:03:55.000+01:00"));
        absence1.setAdmitterNote("");

        absence2.setId(2521L);
        absence2.setCrew(crew);
        absence2.setUser(user4);
        absence2.setType(AbsenceType.vacation);
        absence2.setCreatedAt(ZonedDateTime.parse("2021-01-03T17:36:52.000+01:00"));
        absence2.setStartDate(Date.valueOf("2021-01-05"));
        absence2.setEndDate(Date.valueOf("2021-01-05"));
        absence2.setMemberNote("ganzer tag");
        absence2.setAdmitter(user1);
        absence2.setRejectedAt(ZonedDateTime.parse("2021-01-03T17:39:50.000+01:00"));
        absence2.setAdmitterNote("Sorry");

        absence3.setId(2634L);
        absence3.setCrew(crew);
        absence3.setUser(user2);
        absence3.setType(AbsenceType.vacation);
        absence3.setCreatedAt(ZonedDateTime.parse("2021-01-25T10:04:51.000+01:00"));
        absence3.setStartDate(Date.valueOf("2021-01-11"));
        absence3.setEndDate(Date.valueOf("2021-01-11"));
        absence3.setMemberNote("Nachmittag 0,5 Tage. Danke.");
        absence3.setAdmitter(user1);
        absence3.setConfirmedAt(ZonedDateTime.parse("2021-01-09T18:43:29.000+01:00"));
        absence3.setAdmitterNote("");

        absence4.setId(2904L);
        absence4.setCrew(crew);
        absence4.setUser(user7);
        absence4.setType(AbsenceType.vacation);
        absence4.setCreatedAt(ZonedDateTime.parse("2021-01-03T17:36:52.000+01:00"));
        absence4.setStartDate(Date.valueOf("2021-02-02"));
        absence4.setEndDate(Date.valueOf("2021-02-06"));
        absence4.setMemberNote("");
        absence4.setAdmitter(user1);
        absence4.setRejectedAt(ZonedDateTime.parse("2021-01-25T10:14:44.000+01:00"));
        absence4.setAdmitterNote("");

        absence5.setId(2909L);
        absence5.setCrew(crew);
        absence5.setUser(user9);
        absence5.setType(AbsenceType.vacation);
        absence5.setCreatedAt(ZonedDateTime.parse("2021-01-25T11:06:19.000+01:00"));
        absence5.setStartDate(Date.valueOf("2021-02-23"));
        absence5.setEndDate(Date.valueOf("2021-03-11"));
        absence5.setMemberNote("");
        absence5.setAdmitter(user1);
        absence5.setConfirmedAt(ZonedDateTime.parse("2021-01-27T17:35:03.000+01:00"));
        absence5.setAdmitterNote("");

        absence6.setId(2942L);
        absence6.setCrew(crew);
        absence6.setUser(user4);
        absence6.setType(AbsenceType.vacation);
        absence6.setCreatedAt(ZonedDateTime.parse("2021-01-27T15:52:59.000+01:00"));
        absence6.setStartDate(Date.valueOf("2021-02-03"));
        absence6.setEndDate(Date.valueOf("2021-02-03"));
        absence6.setMemberNote("Urlaub");
        absence6.setAdmitter(user1);
        absence6.setConfirmedAt(ZonedDateTime.parse("2021-01-27T17:34:25.000+01:00"));
        absence6.setAdmitterNote("");

        absence7.setId(2943L);
        absence7.setCrew(crew);
        absence7.setUser(user2);
        absence7.setType(AbsenceType.vacation);
        absence7.setCreatedAt(ZonedDateTime.parse("2021-01-27T17:34:31.000+01:00"));
        absence7.setStartDate(Date.valueOf("2021-03-03"));
        absence7.setEndDate(Date.valueOf("2021-03-03"));
        absence7.setMemberNote("");
        absence7.setAdmitter(user1);
        absence7.setConfirmedAt(ZonedDateTime.parse("2021-01-27T17:34:31.000+01:00"));
        absence7.setAdmitterNote("");

        absence8.setId(2955L);
        absence8.setCrew(crew);
        absence8.setUser(user6);
        absence8.setType(AbsenceType.vacation);
        absence8.setCreatedAt(ZonedDateTime.parse("2021-01-27T17:34:31.000+01:00"));
        absence8.setStartDate(Date.valueOf("2021-03-27"));
        absence8.setEndDate(Date.valueOf("2021-04-07"));
        absence8.setMemberNote("");
        absence8.setAdmitter(user1);
        absence8.setConfirmedAt(ZonedDateTime.parse("2021-03-05T09:31:55.000+01:00"));
        absence8.setAdmitterNote("");

        absence9.setId(3229L);
        absence9.setCrew(crew);
        absence9.setUser(user6);
        absence9.setType(AbsenceType.vacation);
        absence9.setCreatedAt(ZonedDateTime.parse("2021-01-27T17:34:31.000+01:00"));
        absence9.setStartDate(Date.valueOf("2021-03-27"));
        absence9.setEndDate(Date.valueOf("2021-04-07"));
        absence9.setMemberNote("");
        absence9.setAdmitter(user1);
        absence9.setConfirmedAt(ZonedDateTime.parse("2021-03-05T09:31:55.000+01:00"));
        absence9.setAdmitterNote("");

        absence10.setId(3269L);
        absence10.setCrew(crew);
        absence10.setUser(user5);
        absence10.setType(AbsenceType.vacation);
        absence10.setCreatedAt(ZonedDateTime.parse("2021-02-14T15:41:26.000+01:00"));
        absence10.setStartDate(Date.valueOf("2021-02-20"));
        absence10.setEndDate(Date.valueOf("2021-02-25"));
        absence10.setMemberNote("Den alten Urlaubsantrag vom 29.03.2017 - 31.03.2017 bitte löschen.\nDanke :)");
        absence10.setAdmitter(user1);
        absence10.setConfirmedAt(ZonedDateTime.parse("2021-02-14T15:43:06.000+01:00"));
        absence10.setAdmitterNote("Leider sind Wolfram und Phillip schon im Urlaub. Geh lieber mal im März");

        absence11.setId(3597L);
        absence11.setCrew(crew);
        absence11.setUser(user4);
        absence11.setType(AbsenceType.vacation);
        absence11.setCreatedAt(ZonedDateTime.parse("2021-03-01T09:56:26.000+01:00"));
        absence11.setStartDate(Date.valueOf("2021-03-30"));
        absence11.setEndDate(Date.valueOf("2021-03-31"));
        absence11.setMemberNote("");
        absence11.setAdmitter(user1);
        absence11.setConfirmedAt(ZonedDateTime.parse("2021-03-09T17:06:46.000+01:00"));
        absence11.setAdmitterNote("Viel Spaß");

        absence12.setId(3597L);
        absence12.setCrew(crew);
        absence12.setUser(user5);
        absence12.setType(AbsenceType.vacation);
        absence12.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:01:46.000+01:00"));
        absence12.setStartDate(Date.valueOf("2021-03-13"));
        absence12.setEndDate(Date.valueOf("2021-03-13"));
        absence12.setMemberNote("");
        absence12.setAdmitter(user1);
        absence12.setConfirmedAt(ZonedDateTime.parse("2021-03-09T17:06:46.000+01:00"));
        absence12.setAdmitterNote("Viel Spaß");

        absence13.setId(3600L);
        absence13.setCrew(crew);
        absence13.setUser(user1);
        absence13.setType(AbsenceType.vacation);
        absence13.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:33:35.000+01:00"));
        absence13.setStartDate(Date.valueOf("2021-03-10"));
        absence13.setEndDate(Date.valueOf("2021-03-10"));
        absence13.setMemberNote("");
        absence13.setAdmitter(user1);
        absence13.setConfirmedAt(ZonedDateTime.parse("2021-03-09T15:33:35.000+01:00"));
        absence13.setAdmitterNote("");

        absence14.setId(3601L);
        absence14.setCrew(crew);
        absence14.setUser(user1);
        absence14.setType(AbsenceType.vacation);
        absence14.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:33:57.000+01:00"));
        absence14.setStartDate(Date.valueOf("2021-03-10"));
        absence14.setEndDate(Date.valueOf("2021-03-10"));
        absence14.setMemberNote("");
        absence14.setAdmitter(user1);
        absence14.setConfirmedAt(ZonedDateTime.parse("2021-03-09T15:33:35.000+01:00"));
        absence14.setAdmitterNote("");

        absence15.setId(3604L);
        absence15.setCrew(crew);
        absence15.setUser(user10);
        absence15.setType(AbsenceType.vacation);
        absence15.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:34:57.000+01:00"));
        absence15.setStartDate(Date.valueOf("2021-03-13"));
        absence15.setEndDate(Date.valueOf("2021-03-13"));
        absence15.setMemberNote("");
        absence15.setAdmitter(user1);
        absence15.setConfirmedAt(ZonedDateTime.parse("2021-03-09T15:34:57.000+01:00"));
        absence15.setAdmitterNote("");

        absence16.setId(709L);
        absence16.setCrew(crew);
        absence16.setUser(user9);
        absence16.setType(AbsenceType.sickness);
        absence16.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:35:17.000+01:00"));
        absence16.setStartDate(Date.valueOf("2021-03-14"));
        absence16.setEndDate(Date.valueOf("2021-03-15"));
        absence16.setMemberNote("");
        absence16.setAdmitter(user1);
        absence16.setConfirmedAt(ZonedDateTime.parse("2021-03-09T15:35:17.000+01:00"));
        absence16.setAdmitterNote("");

        absence17.setId(3606L);
        absence17.setCrew(crew);
        absence17.setUser(user8);
        absence17.setType(AbsenceType.vacation);
        absence17.setCreatedAt(ZonedDateTime.parse("2021-03-09T15:35:58.000+01:00"));
        absence17.setStartDate(Date.valueOf("2021-03-16"));
        absence17.setEndDate(Date.valueOf("2021-03-18"));
        absence17.setMemberNote("");
        absence17.setAdmitter(user1);
        absence17.setConfirmedAt(ZonedDateTime.parse("2021-03-09T15:35:58.000+01:00"));
        absence17.setAdmitterNote("ok");

        absence18.setId(3618L);
        absence18.setCrew(crew);
        absence18.setUser(user7);
        absence18.setType(AbsenceType.vacation);
        absence18.setCreatedAt(ZonedDateTime.parse("2021-03-09T19:16:51.000+01:00"));
        absence18.setStartDate(Date.valueOf("2021-03-13"));
        absence18.setEndDate(Date.valueOf("2021-03-13"));
        absence18.setMemberNote("");
        absence18.setAdmitter(user1);
        absence18.setConfirmedAt(ZonedDateTime.parse("2021-03-09T19:16:51.000+01:00"));
        absence18.setAdmitterNote("");

        absence19.setId(3629L);
        absence19.setCrew(crew);
        absence19.setUser(user4);
        absence19.setType(AbsenceType.vacation);
        absence19.setCreatedAt(ZonedDateTime.parse("2021-03-10T09:19:42.000+01:00"));
        absence19.setStartDate(Date.valueOf("2021-06-14"));
        absence19.setEndDate(Date.valueOf("2021-06-16"));
        absence19.setMemberNote("");
        absence19.setAdmitter(user1);
        absence19.setConfirmedAt(ZonedDateTime.parse("2021-03-10T09:19:42.000+01:00"));
        absence19.setAdmitterNote("");

        absence20.setId(3656L);
        absence20.setCrew(crew);
        absence20.setUser(user6);
        absence20.setType(AbsenceType.vacation);
        absence20.setCreatedAt(ZonedDateTime.parse("2021-03-10T19:37:23.000+01:00"));
        absence20.setStartDate(Date.valueOf("2021-03-11"));
        absence20.setEndDate(Date.valueOf("2021-03-11"));
        absence20.setMemberNote("");
        absence20.setAdmitter(user1);
        absence20.setConfirmedAt(ZonedDateTime.parse("2021-03-10T19:37:23.000+01:00"));
        absence20.setAdmitterNote("Works nicely!");

        absence21.setId(3690L);
        absence21.setCrew(crew);
        absence21.setUser(user2);
        absence21.setType(AbsenceType.vacation);
        absence21.setCreatedAt(ZonedDateTime.parse("2021-03-14T09:32:42.000+01:00"));
        absence21.setStartDate(Date.valueOf("2021-03-13"));
        absence21.setEndDate(Date.valueOf("2021-03-13"));
        absence21.setMemberNote("");
        absence21.setAdmitter(user1);
        absence21.setConfirmedAt(ZonedDateTime.parse("2021-03-14T17:00:59.000+01:00"));
        absence21.setAdmitterNote("Viel Spaß!");

        absence22.setId(3748L);
        absence22.setCrew(crew);
        absence22.setUser(user6);
        absence22.setType(AbsenceType.vacation);
        absence22.setCreatedAt(ZonedDateTime.parse("2021-03-15T14:54:31.000+01:00"));
        absence22.setStartDate(Date.valueOf("2021-04-21"));
        absence22.setEndDate(Date.valueOf("2021-04-22"));
        absence22.setMemberNote("Barcamp Salzburg");
        absence22.setAdmitter(user1);
        absence22.setConfirmedAt(ZonedDateTime.parse("2021-03-21T18:29:49.000+01:00"));
        absence22.setAdmitterNote("");

        absence23.setId(3752L);
        absence23.setCrew(crew);
        absence23.setUser(user9);
        absence23.setType(AbsenceType.vacation);
        absence23.setCreatedAt(ZonedDateTime.parse("2021-03-15T16:36:34.000+01:00"));
        absence23.setStartDate(Date.valueOf("2020-12-31"));
        absence23.setEndDate(Date.valueOf("2021-01-02"));
        absence23.setMemberNote("");
        absence23.setAdmitter(user1);
        absence23.setConfirmedAt(ZonedDateTime.parse("2021-03-15T16:36:34.000+01:00"));
        absence23.setAdmitterNote("");

        absence24.setId(3884L);
        absence24.setCrew(crew);
        absence24.setUser(user10);
        absence24.setType(AbsenceType.vacation);
        absence24.setCreatedAt(ZonedDateTime.parse("2021-03-20T22:18:53.000+01:00"));
        absence24.setStartDate(Date.valueOf("2021-08-24"));
        absence24.setEndDate(Date.valueOf("2021-09-11"));
        absence24.setMemberNote("Sommerurlaub");
        absence24.setAdmitter(user1);
        absence24.setConfirmedAt(ZonedDateTime.parse("2021-03-20T22:18:53.000+01:00"));
        absence24.setAdmitterNote("");

        absence25.setId(4101L);
        absence25.setCrew(crew);
        absence25.setUser(user7);
        absence25.setType(AbsenceType.vacation);
        absence25.setCreatedAt(ZonedDateTime.parse("2021-03-26T23:52:11.000+02:00"));
        absence25.setStartDate(Date.valueOf("2021-03-27"));
        absence25.setEndDate(Date.valueOf("2021-03-27"));
        absence25.setMemberNote("");
        absence25.setAdmitter(user1);
        absence25.setRejectedAt(ZonedDateTime.parse("2021-03-27T08:18:32.000+02:00"));
        absence25.setAdmitterNote("");

        absence26.setId(4462L);
        absence26.setCrew(crew);
        absence26.setUser(user7);
        absence26.setType(AbsenceType.sickness);
        absence26.setCreatedAt(ZonedDateTime.parse("2021-04-07T16:45:28.000+02:00"));
        absence26.setStartDate(Date.valueOf("2021-04-11"));
        absence26.setEndDate(Date.valueOf("2021-04-11"));
        absence26.setMemberNote("");
        absence26.setAdmitter(user1);
        absence26.setConfirmedAt(ZonedDateTime.parse("2021-04-07T16:45:28.000+02:00"));
        absence26.setAdmitterNote("");

        absence27.setId(4470L);
        absence27.setCrew(crew);
        absence27.setUser(user8);
        absence27.setType(AbsenceType.vacation);
        absence27.setCreatedAt(ZonedDateTime.parse("2021-04-08T20:12:29.000+02:00"));
        absence27.setStartDate(Date.valueOf("2021-04-12"));
        absence27.setEndDate(Date.valueOf("2021-04-12"));
        absence27.setMemberNote("");
        absence27.setAdmitter(user1);
        absence27.setConfirmedAt(ZonedDateTime.parse("2021-04-08T21:16:26.000+02:00"));
        absence27.setAdmitterNote("");

        absence28.setId(4471L);
        absence28.setCrew(crew);
        absence28.setUser(user4);
        absence28.setType(AbsenceType.vacation);
        absence28.setCreatedAt(ZonedDateTime.parse("2021-04-08T20:12:29.000+02:00"));
        absence28.setStartDate(Date.valueOf("2021-04-12"));
        absence28.setEndDate(Date.valueOf("2021-04-12"));
        absence28.setMemberNote("bitte den urlaub in der vorwoche  17-21 zurückziehen. merci :)");
        absence28.setAdmitter(user1);
        absence28.setConfirmedAt(ZonedDateTime.parse("2021-04-11T08:24:06.000+02:00"));
        absence28.setAdmitterNote("");

        absence29.setId(4626L);
        absence29.setCrew(crew);
        absence29.setUser(user2);
        absence29.setType(AbsenceType.vacation);
        absence29.setCreatedAt(ZonedDateTime.parse("2021-04-19T14:35:11.000+02:00"));
        absence29.setStartDate(Date.valueOf("2021-07-10"));
        absence29.setEndDate(Date.valueOf("2021-07-28"));
        absence29.setMemberNote("");
        absence29.setAdmitter(user1);
        absence29.setConfirmedAt(ZonedDateTime.parse("2021-04-19T11:20:48.000+02:00"));
        absence29.setAdmitterNote("");

        absence30.setId(4753L);
        absence30.setCrew(crew);
        absence30.setUser(user3);
        absence30.setType(AbsenceType.vacation);
        absence30.setCreatedAt(ZonedDateTime.parse("2021-04-26T09:55:40.000+02:00"));
        absence30.setStartDate(Date.valueOf("2021-04-28"));
        absence30.setEndDate(Date.valueOf("2021-04-28"));
        absence30.setMemberNote("");
        absence30.setAdmitter(user1);
        absence30.setConfirmedAt(ZonedDateTime.parse("2021-04-26T15:12:11.000+02:00"));
        absence30.setAdmitterNote("Schönes langes WE!");

        absence31.setId(5291L);
        absence31.setCrew(crew);
        absence31.setUser(user5);
        absence31.setType(AbsenceType.sickness);
        absence31.setCreatedAt(ZonedDateTime.parse("2021-05-12T09:27:30.000+02:00"));
        absence31.setStartDate(Date.valueOf("2021-06-26"));
        absence31.setEndDate(Date.valueOf("2021-06-26"));
        absence31.setMemberNote("");

        absence32.setId(5293L);
        absence32.setCrew(crew);
        absence32.setUser(user2);
        absence32.setType(AbsenceType.vacation);
        absence32.setCreatedAt(ZonedDateTime.parse("2021-05-12T09:43:25.000+02:00"));
        absence32.setStartDate(Date.valueOf("2021-06-19"));
        absence32.setEndDate(Date.valueOf("2021-06-23"));
        absence32.setMemberNote("");
        absence32.setAdmitter(user1);
        absence32.setConfirmedAt(ZonedDateTime.parse("2021-05-12T10:18:50.000+02:00"));
        absence32.setAdmitterNote("");

        absence33.setId(5409L);
        absence33.setCrew(crew);
        absence33.setUser(user3);
        absence33.setType(AbsenceType.vacation);
        absence33.setCreatedAt(ZonedDateTime.parse("2021-05-16T10:50:30.000+02:00"));
        absence33.setStartDate(Date.valueOf("2021-05-18"));
        absence33.setEndDate(Date.valueOf("2021-05-18"));
        absence33.setMemberNote("");
        absence33.setAdmitter(user1);
        absence33.setConfirmedAt(ZonedDateTime.parse("2021-05-12T10:18:50.000+02:00"));
        absence33.setAdmitterNote("");

        absence34.setId(5555L);
        absence34.setCrew(crew);
        absence34.setUser(user6);
        absence34.setType(AbsenceType.vacation);
        absence34.setCreatedAt(ZonedDateTime.parse("2021-05-21T17:24:42.000+02:00"));
        absence34.setStartDate(Date.valueOf("2021-05-24"));
        absence34.setEndDate(Date.valueOf("2021-05-24"));
        absence34.setMemberNote("");
        absence34.setAdmitter(user1);
        absence34.setConfirmedAt(ZonedDateTime.parse("2021-05-22T08:50:28.000+02:00"));
        absence34.setAdmitterNote("");

        absence35.setId(5740L);
        absence35.setCrew(crew);
        absence35.setUser(user6);
        absence35.setType(AbsenceType.vacation);
        absence35.setCreatedAt(ZonedDateTime.parse("2021-05-26T16:52:41.000+02:00"));
        absence35.setStartDate(Date.valueOf("2021-05-30"));
        absence35.setEndDate(Date.valueOf("2021-05-30"));
        absence35.setMemberNote("");
        absence35.setAdmitter(user1);
        absence35.setConfirmedAt(ZonedDateTime.parse("2021-05-26T16:05:37.000+02:00"));
        absence35.setAdmitterNote("");

        absence36.setId(5769L);
        absence36.setCrew(crew);
        absence36.setUser(user9);
        absence36.setType(AbsenceType.vacation);
        absence36.setCreatedAt(ZonedDateTime.parse("2021-05-29T08:42:59.000+02:00"));
        absence36.setStartDate(Date.valueOf("2021-05-30"));
        absence36.setEndDate(Date.valueOf("2021-05-30"));
        absence36.setMemberNote("");

        absence37.setId(5879L);
        absence37.setCrew(crew);
        absence37.setUser(user10);
        absence37.setType(AbsenceType.sickness);
        absence37.setCreatedAt(ZonedDateTime.parse("2021-05-30T16:33:57.000+02:00"));
        absence37.setStartDate(Date.valueOf("2021-08-05"));
        absence37.setEndDate(Date.valueOf("2021-08-20"));
        absence37.setMemberNote("");
        absence37.setAdmitter(user1);
        absence37.setConfirmedAt(ZonedDateTime.parse("2021-05-31T08:55:37.000+02:00"));
        absence37.setAdmitterNote("");

        absence38.setId(6310L);
        absence38.setCrew(crew);
        absence38.setUser(user9);
        absence38.setType(AbsenceType.vacation);
        absence38.setCreatedAt(ZonedDateTime.parse("2021-06-12T15:21:08.000+02:00"));
        absence38.setStartDate(Date.valueOf("2021-06-26"));
        absence38.setEndDate(Date.valueOf("2021-06-27"));
        absence38.setMemberNote("");
        absence38.setAdmitter(user1);
        absence38.setConfirmedAt(ZonedDateTime.parse("2021-06-13T07:51:28.000+02:00"));
        absence38.setAdmitterNote("");

        absence39.setId(6311L);
        absence39.setCrew(crew);
        absence39.setUser(user9);
        absence39.setType(AbsenceType.vacation);
        absence39.setCreatedAt(ZonedDateTime.parse("2021-06-12T15:21:16.000+02:00"));
        absence39.setStartDate(Date.valueOf("2021-06-26"));
        absence39.setEndDate(Date.valueOf("2021-06-27"));
        absence39.setMemberNote("");

        absence40.setId(6886L);
        absence40.setCrew(crew);
        absence40.setUser(user9);
        absence40.setType(AbsenceType.vacation);
        absence40.setCreatedAt(ZonedDateTime.parse("2021-06-30T02:13:56.000+02:00"));
        absence40.setStartDate(Date.valueOf("2021-08-05"));
        absence40.setEndDate(Date.valueOf("2021-08-12"));
        absence40.setMemberNote("Pfadfindersommerlager");

        absence41.setId(7886L);
        absence41.setCrew(crew);
        absence41.setUser(user8);
        absence41.setType(AbsenceType.vacation);
        absence41.setCreatedAt(ZonedDateTime.parse("2021-07-30T02:13:57.000+02:00"));
        absence41.setStartDate(Date.valueOf("2021-09-04"));
        absence41.setEndDate(Date.valueOf("2021-09-12"));
        absence41.setMemberNote("");

        absence42.setId(7887L);
        absence42.setCrew(crew);
        absence42.setUser(user8);
        absence42.setType(AbsenceType.vacation);
        absence42.setCreatedAt(ZonedDateTime.parse("2021-08-30T02:13:58.000+02:00"));
        absence42.setStartDate(Date.valueOf("2021-10-04"));
        absence42.setEndDate(Date.valueOf("2021-10-13"));
        absence42.setMemberNote("");

        absenceRepository.save(absence1);
        absenceRepository.save(absence2);
        absenceRepository.save(absence3);
        absenceRepository.save(absence4);
        absenceRepository.save(absence5);
        absenceRepository.save(absence6);
        absenceRepository.save(absence7);
        absenceRepository.save(absence8);
        absenceRepository.save(absence9);
        absenceRepository.save(absence10);
        absenceRepository.save(absence11);
        absenceRepository.save(absence12);
        absenceRepository.save(absence13);
        absenceRepository.save(absence14);
        absenceRepository.save(absence15);
        absenceRepository.save(absence16);
        absenceRepository.save(absence17);
        absenceRepository.save(absence18);
        absenceRepository.save(absence19);
        absenceRepository.save(absence20);
        absenceRepository.save(absence21);
        absenceRepository.save(absence22);
        absenceRepository.save(absence23);
        absenceRepository.save(absence24);
        absenceRepository.save(absence25);
        absenceRepository.save(absence26);
        absenceRepository.save(absence27);
        absenceRepository.save(absence28);
        absenceRepository.save(absence29);
        absenceRepository.save(absence30);
        absenceRepository.save(absence41);
        absenceRepository.save(absence42);
    }
}
