package org.questionnaire.entity;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.questionnaire.entity.Quest;
import org.questionnaire.hibernate.HibernateUtil;

import java.util.List;

public class QuestHelper {
//    public List<Quest> getQuestList() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        String hql = "from Quest";
//        Query query = session.createQuery(hql, Quest.class);
//        List<Quest> quests = query.getResultList();
//        session.close();
//        return quests;
//    }

//    public Quest addQuest(Quest quest) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.persist(quest);
//        session.getTransaction().commit();
//        session.close();
//        return quest;
//    }

//    public Quest updateQuest(Quest quest) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.persist(quest);
//        session.getTransaction().commit();
//        session.close();
//        return quest;
//    }

    public List<Quest> findQuest(String request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "from Quest where quest like '%" + request + "%'";
        Query query = session.createQuery(hql, Quest.class);
        List<Quest> quests = query.getResultList();
        session.close();
        return quests;
    }

//    public Quest removeQuest(Quest quest) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.remove(quest);
//        session.getTransaction().commit();
//        session.close();
//        return null;
//    }
}
