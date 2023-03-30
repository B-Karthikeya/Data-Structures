#include<stdio.h>
#include<stdlib.h>

struct queue{
    int size;
    int f;
    int r ;
    int* arr;
};
int isEmpty(struct queue *q){
    if(q->f == q->r) return 1;
    else return 0;
}
int isFull(struct queue *q){
    if(q->r == q->size -1) return 1;
    else return 0;
}
void enqueue(struct queue *q){
    if(isFull(q)) printf("queue is full\n");
    else {
        int element;
        printf("enter the element :");
        scanf("%d",&element);
        q->r++;
        q->arr[q->r] = element;
    }
}
int dequeue(struct queue *q){
    int a = -1;
    if(isEmpty(q)) printf("queue is empty\n");
    else{
        q->f++;
        a = q->arr[q->f];
    }
    return a;
}
void display(struct queue *q){
    printf("QUEUE : ");
    for(int i = q->f+1;i<=q->r;i++){
        printf("%d\t",q->arr[i]);

    }
    printf("\n");
}

int main(){
    int n,choice;
    struct queue *q = (struct queue *)malloc(sizeof(struct queue));
    printf("enter the size of queue :");
    scanf("%d",&n);
    q->size = n;
    q->arr = (int *) malloc(n*sizeof(int));
    q->f = q->r = -1;

    printf("OPERATIONAL CODES :\n1-enqueue\n2-dequeue\n3-display\n0-exit");
    printf("enter the operational code :");
    scanf("%d",&choice);
    while(choice!=0){
        switch(choice) {
            case 1 : enqueue(q); break;
            case 2 : dequeue(q);break;
            case 3 : display(q);
            case 0 : exit;
            default : printf("enter valid operation");
        }
        // printf("\OPERATIONAL CODES :\n1-enqueue\n2-dequeue\n3-display\n0-exit");
    printf("\nenter the operational code :");
        scanf("%d",&choice);
    }

    return 0;
}