import "./Item.style.css";

function Item({ item, items, setItems }) {
    const index = items.indexOf(item);

    const handleClick = () => {
        const newArray = [...items];

        newArray[index].isCompleted = !newArray[index].isCompleted;

        setItems(newArray);
    };

    return (
        <div className="item-component">
            <button
                onClick={handleClick}
                className={`${
                    item.isCompleted ? "green-button" : "white-button"
                }`}
            ></button>
            <div>{item.taskDescription}</div>
        </div>
    );
}

export default Item;
