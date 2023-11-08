package com.marvel.springbootlibrary2.service;

import com.marvel.springbootlibrary2.dao.BookRepository;
import com.marvel.springbootlibrary2.dao.CheckoutRepository;
import com.marvel.springbootlibrary2.dao.ReviewRepository;
import com.marvel.springbootlibrary2.entity.Book;
import com.marvel.springbootlibrary2.requestmodels.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class AdminService {
    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;
    private CheckoutRepository checkoutRepository;

    @Autowired
    public AdminService(BookRepository bookRepository,
                        ReviewRepository reviewRepository,
                        CheckoutRepository checkoutRepository){
        this.bookRepository=bookRepository;
        this.reviewRepository=reviewRepository;
        this.checkoutRepository=checkoutRepository;
    }
    public void increaseBookQuantity(Long bookId) throws Exception{
        Optional<Book>book=bookRepository.findById(bookId);

        if(!book.isPresent()){
throw new Exception("Book not found");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable()+1);
        book.get().setCopies(book.get().getCopies()+1);

        bookRepository.save(book.get());
    }
    public void decreaseBookQuantity(Long bookId) throws Exception{
        Optional<Book>book=bookRepository.findById(bookId);

        if(!book.isPresent() || book.get().getCopiesAvailable()<=0 || book.get().getCopies()<=0){
            throw new Exception("Book not found or quantity locked");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable()-1);
        book.get().setCopies(book.get().getCopies()-1);

        bookRepository.save(book.get());
    }
    public void postBook(AddBookRequest addBookRequest){
        Book book=new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopies(addBookRequest.getCopies());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCategory(addBookRequest.getCategory());
        book.setImg(addBookRequest.getImg());
        bookRepository.save(book);

    }
    public void deleteBook(Long bookId) throws Exception{
        Optional<Book> book=bookRepository.findById(bookId);
        if(!book.isPresent()){
            throw new Exception("Book not found");
        }
        bookRepository.delete(book.get());
        checkoutRepository.deleteAllByBookId(bookId);
        reviewRepository.deleteAllByBookId(bookId);

    }
}
