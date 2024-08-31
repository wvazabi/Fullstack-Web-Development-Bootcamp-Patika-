import React, { useState, useEffect } from 'react';
import { Search, Plus, X } from 'lucide-react';

const NoteApp = () => {
  // State hooks for managing notes, new note input, color selection, and search term
  const [notes, setNotes] = useState([]);
  const [newNote, setNewNote] = useState('');
  const [selectedColor, setSelectedColor] = useState('#ffffff');
  const [searchTerm, setSearchTerm] = useState('');

  // Predefined color palette
  const colors = ['#ffffff', '#fecaca', '#fde68a', '#bbf7d0', '#bfdbfe', '#ddd6fe', '#fbcfe8'];

  // Load notes from localStorage on component mount
  useEffect(() => {
    const savedNotes = localStorage.getItem('notes');
    if (savedNotes) {
      setNotes(JSON.parse(savedNotes));
    }
  }, []);

  // Save notes to localStorage whenever the notes state changes
  useEffect(() => {
    localStorage.setItem('notes', JSON.stringify(notes));
  }, [notes]);

  // Function to add a new note
  const addNote = () => {
    if (newNote.trim() !== '') {
      setNotes([...notes, { text: newNote, color: selectedColor, id: Date.now() }]);
      setNewNote('');
    }
  };

  // Function to delete a note
  const deleteNote = (id) => {
    setNotes(notes.filter(note => note.id !== id));
  };

  // Filter notes based on the search term
  const filteredNotes = notes.filter(note =>
    note.text.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="min-h-screen bg-gray-100 py-8">
      <div className="container mx-auto px-4 max-w-4xl">
        <h1 className="text-4xl font-bold mb-8 text-center text-gray-800">Noteworthy</h1>
        
        {/* Note input section */}
        <div className="bg-white rounded-lg shadow-md p-6 mb-8">
          <textarea
            className="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
            rows="4"
            value={newNote}
            onChange={(e) => setNewNote(e.target.value)}
            placeholder="Write your note here..."
          ></textarea>
          
          <div className="flex items-center justify-between mt-4">
            <div className="flex items-center">
              {colors.map(color => (
                <button
                  key={color}
                  className={`w-8 h-8 rounded-full mr-2 transition-transform transform hover:scale-110 ${selectedColor === color ? 'ring-2 ring-blue-500 ring-offset-2' : ''}`}
                  style={{ backgroundColor: color }}
                  onClick={() => setSelectedColor(color)}
                ></button>
              ))}
            </div>
            <button
              className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-md transition duration-300 ease-in-out flex items-center"
              onClick={addNote}
            >
              <Plus size={20} className="mr-2" />
              Add Note
            </button>
          </div>
        </div>
        
        {/* Search input */}
        <div className="relative mb-8">
          <input
            type="text"
            className="w-full p-3 pl-12 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
            placeholder="Search notes..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-gray-400" size={20} />
        </div>
        
        {/* Notes grid */}
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {filteredNotes.map(note => (
            <div
              key={note.id}
              className="p-4 rounded-lg shadow-md relative overflow-hidden transition-all duration-300 hover:shadow-lg"
              style={{ backgroundColor: note.color }}
            >
              <button
                onClick={() => deleteNote(note.id)}
                className="absolute top-2 right-2 text-gray-500 hover:text-red-500 transition-colors duration-300"
              >
                <X size={20} />
              </button>
              <p className="text-gray-800 break-words">{note.text}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default NoteApp;