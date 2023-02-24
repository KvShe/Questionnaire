package org.questionnaire;

import org.hibernate.Session;
import org.questionnaire.entity.Quest;
import org.questionnaire.hibernate.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Quest> quests = Quest.getQuestList();
        quests.forEach(System.out::println);

        session.close();
    }
}
