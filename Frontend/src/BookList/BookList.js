import React, {Component} from 'react';
import Book from './Book';
import BookService from './BookService';

class BookList extends Component {
  constructor(props) {
    super(props);
    this.state = {books: []};
  }
  componentDidMount() {
    BookService.getBooks().then(response => {
      this.setState({books: response.data});
    })
  }
  render() {
    return this.state.books.map(book => <Book key={book.name} {...book} />);
  }
}

export default BookList;
