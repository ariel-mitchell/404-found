//package org.launchcode.fourohfourfound.finalproject.service;

// import jakarta.annotation.PostConstruct;
// import org.hibernate.SessionFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component
// public class CacheInitializer {

//     @Autowired
//     private SessionFactory sessionFactory;

//     @PostConstruct
//     public void clearHibernateCache() {
//         if (sessionFactory != null) {
//             sessionFactory.getCache().evictAllRegions();
//         }
//     }
// }
