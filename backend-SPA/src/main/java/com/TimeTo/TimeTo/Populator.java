package com.TimeTo.TimeTo;

import com.TimeTo.TimeTo.Models.*;
import com.TimeTo.TimeTo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        UserAccount userAccount1 = new UserAccount("Stuart", "Maxwell", "stumax7");
        userRepository.save(userAccount1);
        UserAccount userAccount2 = new UserAccount("Gaelan", "Shively", "Praetor");
        userRepository.save(userAccount2);
        UserAccount userAccount3 = new UserAccount("Anna", "Lizon", "FreeRangeLocust");
        userRepository.save(userAccount3);
        UserAccount userAccount4 = new UserAccount("Fatuma", "Pemba", "fpemba");
        userRepository.save(userAccount4);
        UserAccount userAccount5 = new UserAccount("Brian", "Waterman", "bwaterman");
        userRepository.save(userAccount5);


        for (UserAccount userAccount : userRepository.findAll()) {
            Calendar masterCalendar = new Calendar();
            calendarRepository.save(masterCalendar);
            Account accountCreated = new Account(userAccount, masterCalendar);
            accountCreated.addFriend(userAccount1);
            accountCreated.addFriend(userAccount2);
            accountCreated.addFriend(userAccount3);
            accountCreated.addFriend(userAccount4);
            accountCreated.addFriend(userAccount5);
            accountRepository.save(accountCreated);



            String id = accountCreated.getUserName() + "April2020";
            Month april2020 = new Month("April", 4, 4, 2020, masterCalendar, 30, id);
            monthRepository.save(april2020);
            createAprilDays(april2020, accountCreated);

            id = accountCreated.getUserName() + "May2020";
            Month may2020 = new Month("May", 5, 6, 2020, masterCalendar, 31, id);
            monthRepository.save(may2020);
            createMayDays(may2020, accountCreated);

            id = accountCreated.getUserName() + "June2020";
            Month june2020 = new Month("June", 6, 2, 2020, masterCalendar, 30, id);
            monthRepository.save(june2020);
            createJuneDays(june2020, accountCreated);

            id = accountCreated.getUserName() + "July2020";
            Month july2020 = new Month("July", 7, 4, 2020, masterCalendar, 31, id);
            monthRepository.save(july2020);
            createJulyDays(july2020, accountCreated);

            id = accountCreated.getUserName() + "August2020";
            Month august2020 = new Month("August", 8, 7, 2020, masterCalendar, 31, id);
            monthRepository.save(august2020);
            createAugustDays(august2020, accountCreated);

            id = accountCreated.getUserName() + "September2020";
            Month september2020 = new Month("September", 9, 3, 2020, masterCalendar, 30, id);
            monthRepository.save(september2020);
            createSeptemberDays(september2020, accountCreated);

            id = accountCreated.getUserName() + "October2020";
            Month october2020 = new Month("October", 10, 5, 2020, masterCalendar, 31, id);
            monthRepository.save(october2020);
            createOctoberDays(october2020, accountCreated);

            id = accountCreated.getUserName() + "November2020";
            Month november2020 = new Month("November", 11, 1, 2020, masterCalendar, 30, id);
            monthRepository.save(november2020);
            createNovemberDays(november2020, accountCreated);

            id = accountCreated.getUserName() + "December2020";
            Month december2020 = new Month("December", 12, 3, 2020, masterCalendar, 31, id);
            monthRepository.save(december2020);
            createDecemberDays(december2020, accountCreated);
        }

    }

    private void createJanuaryDays(Month january, Account account) {
        for (int i = 1; i <= january.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-01-0" + i + "-" + january.getYear();
            } else {
                idToSet = account.getUserName() + "-01-" + i + "-" + january.getYear();
            }
            Day newDay = new Day(idToSet, january, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createFebruaryDays(Month february, Account account) {
        for (int i = 1; i <= february.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-02-0" + i + "-" + february.getYear();
            } else {
                idToSet = account.getUserName() + "-02-" + i + "-" + february.getYear();
            }
            Day newDay = new Day(idToSet, february, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createMarchDays(Month march, Account account) {
        for (int i = 1; i <= march.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-03-0" + i + "-" + march.getYear();
            } else {
                idToSet = account.getUserName() + "-03-" + i + "-" + march.getYear();
            }
            Day newDay = new Day(idToSet, march, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createAprilDays(Month april, Account account) {
        for (int i = 1; i <= april.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-04-0" + i + "-" + april.getYear();
            } else {
                idToSet = account.getUserName() + "-04-" + i + "-" + april.getYear();
            }
            Day newDay = new Day(idToSet, april, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createMayDays(Month may, Account account) {
        for (int i = 1; i <= may.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-05-0" + i + "-" + may.getYear();
            } else {
                idToSet = account.getUserName() + "-05-" + i + "-" + may.getYear();
            }
            Day newDay = new Day(idToSet, may, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createJuneDays(Month june, Account account) {
        for (int i = 1; i <= june.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-06-0" + i + "-" + june.getYear();
            } else {
                idToSet = account.getUserName() + "-06-" + i + "-" + june.getYear();
            }
            Day newDay = new Day(idToSet, june, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createJulyDays(Month july, Account account) {
        for (int i = 1; i <= july.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-07-0" + i + "-" + july.getYear();
            } else {
                idToSet = account.getUserName() + "-07-" + i + "-" + july.getYear();
            }
            Day newDay = new Day(idToSet, july, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createAugustDays(Month august, Account account) {
        for (int i = 1; i <= august.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-08-0" + i + "-" + august.getYear();
            } else {
                idToSet = account.getUserName() + "-08-" + i + "-" + august.getYear();
            }
            Day newDay = new Day(idToSet, august, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createSeptemberDays(Month september, Account account) {
        for (int i = 1; i <= september.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-09-0" + i + "-" + september.getYear();
            } else {
                idToSet = account.getUserName() + "-09-" + i + "-" + september.getYear();
            }
            Day newDay = new Day(idToSet, september, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createOctoberDays(Month october, Account account) {
        for (int i = 1; i <= october.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-10-0" + i + "-" + october.getYear();
            } else {
                idToSet = account.getUserName() + "-10-" + i + "-" + october.getYear();
            }
            Day newDay = new Day(idToSet, october, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createNovemberDays(Month november, Account account) {
        for (int i = 1; i <= november.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-11-0" + i + "-" + november.getYear();
            } else {
                idToSet = account.getUserName() + "-11-" + i + "-" + november.getYear();
            }
            Day newDay = new Day(idToSet, november, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createDecemberDays(Month december, Account account) {
        for (int i = 1; i <= december.getLength(); i++) {
            String idToSet;
            if (i < 10) {
                idToSet = account.getUserName() + "-12-0" + i + "-" + december.getYear();
            } else {
                idToSet = account.getUserName() + "-12-" + i + "-" + december.getYear();
            }
            Day newDay = new Day(idToSet, december, i);
            dayRepository.save(newDay);
            createHours(newDay, account);
        }
    }

    private void createHours(Day day, Account account) {
        for (int h = 0; h < 24; h++) {
            LocalTime startTime = LocalTime.of(h, 0, 0);
            int endHour;
            if (h <= 22) {
                endHour = h + 1;
            } else {
                endHour = 0;
            }
            String idToSet = day.getId() + "-" + h;
            LocalTime endTime = LocalTime.of(endHour, 0, 0);
            Event newHour = new Event(account, idToSet, day, true, startTime, endTime, "Free Time!");
            eventRepository.save(newHour);
        }
    }

}

