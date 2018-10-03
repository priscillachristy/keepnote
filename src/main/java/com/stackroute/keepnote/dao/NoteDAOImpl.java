package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database
 * 					transaction. The database transaction happens inside the scope of a persistence
 * 					context.
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	public SessionFactory sessionFactory;
	//private Session session;

	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		//session=sessionFactory.getCurrentSession();
		//session.persist(note);
		sessionFactory.getCurrentSession().save(note);
		//session.getTransaction().commit();
		return true;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		//Query query= (Query) sessionFactory.getCurrentSession().createSQLQuery("delete from Note where noteId= :noteId");
		//((NativeQuery) query).setString("noteId", String.valueOf(noteId));
		//((NativeQuery) query).executeUpdate();
		Session session;
		session=sessionFactory.getCurrentSession();
		session.delete(getNoteById(noteId));
		return true;
	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	@SuppressWarnings("unchecked")
	public List<Note> getAllNotes() {
		//session=sessionFactory.getCurrentSession();
		System.out.println("DSF");
		//CriteriaBuilder builder = session.getCriteriaBuilder();

// Create CriteriaQuery
		//CriteriaQuery<Note> criteria = builder.createQuery(Note.class);
		//Root<Note> root =criteria.from(Note.class);
		//criteria.select(root);
		//Query<Note> q = session.createQuery(criteria);
		//List<Note> list = q.getResultList();

		CriteriaQuery<Note> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Note.class);
		criteriaQuery.from(Note.class);

		List<Note> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
		//Criteria criteria=session.createCriteria(Note.class);
		System.out.println("list ofdd "+list);
		return list;

	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		//session=sessionFactory.getCurrentSession();
		return sessionFactory.getCurrentSession().get(Note.class,noteId);

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		Note note1=getNoteById(note.getNoteId());
		if(note1!=null){
			note1.setNoteTitle(note.getNoteTitle());
			note1.setNoteContent(note.getNoteContent());
			note1.setNoteStatus(note.getNoteStatus());
			return true;
		}
		return false;
	}

}