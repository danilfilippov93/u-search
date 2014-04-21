package ru.mipt.search.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ru.mipt.search.MssFile;


public class MssFileLocator {
    public final static EntityManagerFactory mssEntityManagerFactory = Persistence
            .createEntityManagerFactory("primary_db");

    protected static EntityManager getEntityManager() {
        return mssEntityManagerFactory.createEntityManager();
    }

    public static MssFile findFileById(Integer id) {
        EntityManager dbEntityManager = getEntityManager();
        try {
            Query query = dbEntityManager.createNamedQuery("getFileById");
            query.setParameter("id", id);
            return (MssFile) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            dbEntityManager.close();
        }
    }

    public static List<MssFile> findFilesInRange(int firstResult, int maxResults) {
        EntityManager dbEntityManager = getEntityManager();
        try {
            TypedQuery<MssFile> query = dbEntityManager.createQuery("select file from MssFile file",
                    MssFile.class);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            return (List<MssFile>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            dbEntityManager.close();
        }
    }

    public static List<MssFile> findFilesByName(String name, int firstResult, int maxResults) {
        EntityManager dbEntityManager = getEntityManager();
        try {
            TypedQuery<MssFile> query = dbEntityManager.createQuery("select file from MssFile file where file.name like :name", MssFile.class);
            query.setParameter("name", "%" + name + "%");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            return (List<MssFile>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            dbEntityManager.close();
        }

    }

    public static List<MssFile> findFilesByNameAndServer(String nameContains, String serverName,
            int firstResult, int maxResults) {
        EntityManager dbEntityManager = getEntityManager();
        try {
            TypedQuery<MssFile> query = dbEntityManager.createNamedQuery("getFileByNameAndServer",
                    MssFile.class);
            query.setParameter("name", "%" + nameContains + "%");
            query.setParameter("server", "%" + serverName + "%");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            dbEntityManager.close();
        }
    }

    public static List<MssFile> findFilesByServer(String serverName,
                                                         int firstResult, int maxResults) {
        EntityManager dbEntityManager = getEntityManager();
        try {
            TypedQuery<MssFile> query = dbEntityManager.createQuery("select file from MssFile file where " +
                    "file.serverName like :server", MssFile.class);
            query.setParameter("server", "%" + serverName + "%");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            dbEntityManager.close();
        }
    }


}
