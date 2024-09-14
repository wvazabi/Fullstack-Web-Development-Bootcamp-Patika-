import { useState, useEffect } from "react";
import "./ItemList.style.css";
import Item from "../Item/Item";

function ItemList() {
    const [items, setItems] = useState([]);
    const [filteredItems, setFilteredItems] = useState([]);
    const [filterState, setFilterState] = useState("all");

    useEffect(() => {
        if (filterState === "all") {
            setFilteredItems(items);
        }

        if (filterState === "active") {
            setFilteredItems(items.filter((obj) => !obj.isCompleted));
        }

        if (filterState === "completed") {
            setFilteredItems(items.filter((obj) => obj.isCompleted));
        }
    }, [filterState, items]);


    const takeInput = (event) => {
        const object = {
            taskDescription: event.target.value,
            isCompleted: false,
            isRemoved: false,
        };

        setItems((prevItems) => [...prevItems, object]);
        event.target.value = "";
    };

    useEffect(() => {
        const keyDownHandler = (event) => {
            if (event.key === "Enter") {
                event.preventDefault();

                takeInput(event);
            }
        };

        document.addEventListener("keydown", keyDownHandler);

        return () => {
            document.removeEventListener("keydown", keyDownHandler);
        };
    }, []);


    return (
        <div className="item-list-component">
            <input type="text" />

            {filteredItems.map((item) => {
                return (
                    <Item
                        key={item.taskDescription}
                        item={item}
                        items={items}
                        setItems={setItems}
                    ></Item>
                );
            })}

            <div className="item-info">
                <div className="number-of-items">{items.filter((obj) => !obj.isCompleted).length} left</div>

                <div className="item-buttons">
                    <button onClick={() => setFilterState("all")}>All</button>
                    <button onClick={() => setFilterState("active")}>
                        Active
                    </button>
                    <button onClick={() => setFilterState("completed")}>
                        Completed
                    </button>
                </div>

                <div className="clear-completed-button">
                    <button onClick={() => setItems(items.filter((obj) => !obj.isCompleted))}>Clear completed</button>
                </div>
            </div>
        </div>
    );
}

export default ItemList;
