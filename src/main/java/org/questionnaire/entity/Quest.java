package org.questionnaire.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.questionnaire.hibernate.HibernateUtil;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Quest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quest;
    private String answer;
    private String category;

    public Quest(String quest, String answer, String category) {
        this.quest = quest;
        this.answer = answer;
        this.category = category;
    }

    @Override
    public String toString() {
        return id + " " + quest + " " + answer + " " + category;
    }


    public static List<Quest> getQuestList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "from Quest";
        Query query = session.createQuery(hql, Quest.class);
        List<Quest> quests = query.getResultList();
        session.close();
        return quests;
    }

//    public List<Quest> findQuest(String request) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        String hql = "from Quest where quest like '%" + request + "%'";
//        Query query = session.createQuery(hql, Quest.class);
//        List<Quest> quests = query.getResultList();
//        session.close();
//        return quests;
//    }

    public void addDB() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(this);
        session.getTransaction().commit();
        session.close();
    }

    public void updateDB() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Quest questDB = session.get(Quest.class, this.id);
        questDB.setQuest(this.quest);
        questDB.setAnswer(this.answer);
        questDB.setCategory(this.category);

        session.beginTransaction();
        session.persist(questDB);
        session.getTransaction().commit();
        session.close();
    }

    public void removeDB() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(this);
        session.getTransaction().commit();
        session.close();
    }
}
